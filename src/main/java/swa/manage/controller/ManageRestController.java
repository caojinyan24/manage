package swa.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swa.manage.biz.RoomBiz;
import swa.manage.value.ReserveVo;

import javax.annotation.Resource;

/**
 * Created by jinyan on 7/16/17.
 */
@RequestMapping("manage")
@RestController
public class ManageRestController {
    private static final Logger logger = LoggerFactory.getLogger(ManageRestController.class);
    @Resource
    private RoomBiz roomBiz;

    @RequestMapping("reserveSubmit")
    public String submitReserve(ReserveVo reserveVo) {
        try {
            logger.info("submitReserve-begin:{}", reserveVo);
            ReserveVo.checkParam(reserveVo);
            roomBiz.reserve(reserveVo);
            return "预定成功";
        } catch (Exception e) {
            logger.error("submitReserve error:", e);
            return "预定失败";
        }


    }

    @RequestMapping(value = "/toCancelReserve", method = {RequestMethod.GET, RequestMethod.POST})
    public String toCancelReserve(@RequestParam("id") String id) {
        logger.info("toCancelReserve:{}", id);
        // TODO: 7/18/17  添加取消逻辑
        return "SUCCESS";
    }
}
