package swa.manage.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.biz.RoomBiz;
import swa.manage.common.CacheInfoUtil;
import swa.manage.common.CommonServiceUtil;
import swa.manage.common.ManageException;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.vo.RecordInfoVo;
import swa.manage.entity.vo.SearchVo;
import swa.manage.service.RoomConfigService;
import swa.manage.value.ReserveVo;
import swa.manage.value.TimePeriodEnum;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * USER和ADMIN用户均可访问
 * Created by jinyan on 8/8/17 7:00 PM.
 */
@RequestMapping("reserve")
@Controller
public class ReserveController {
    private static final Logger logger = LoggerFactory.getLogger(ReserveController.class);
    @Resource
    private RoomBiz roomBiz;
    @Resource
    private CacheInfoUtil cacheInfoUtil;
    @Resource
    private RoomConfigService roomConfigService;

    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "roomReserveIndex")
    public ModelAndView roomReServeIndex(SearchVo searchVo) {
        ModelAndView mav = new ModelAndView("roomReserve/roomReserveIndex");
        try {
            List<RecordInfoVo> recordInfoVos = roomBiz.queryAndInitRecords(searchVo);
            mav.addObject("recordInfoVos", recordInfoVos);
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap());
            mav.addObject("searchVo", searchVo);
            mav.addObject("regions", CacheInfoUtil.getRegions(searchVo.getCity()));
            mav.addObject("citys", cacheInfoUtil.getCities());

        } catch (Exception e) {
            mav.addObject("recordInfoVos", Lists.newArrayList());
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap().keySet());
            mav.addObject("searchVo", searchVo);
            mav.addObject("regions", cacheInfoUtil.getRegionMap());
            mav.addObject("citys", cacheInfoUtil.getCities());
            logger.error("roomRecordIndex error", e);
        }
        return mav;
    }


    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "roomReserve", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roomReserve(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date,
                                    @RequestParam("configId") Long configId,
                                    @RequestParam("timePeriods") String timePeriodsStr) {
        ModelAndView mav = new ModelAndView("roomReserve/roomReserve");
        try {
            RoomConfig roomConfig = new RoomConfig();
            roomConfig.setId(configId);
            mav.addObject("roomConfig", roomConfigService.queryValidConfig(roomConfig).get(0));
            mav.addObject("date", date);
            mav.addObject("timePeriods", timePeriodsStr);
            mav.addObject("showTime", CommonServiceUtil.getShowTime(timePeriodsStr));
        } catch (Exception e) {
            logger.error("roomReserve error", e);
        }
        return mav;
    }

    @RequestMapping("reserveSubmit")
    @ResponseBody
    public String submitReserve(ReserveVo reserveVo) {
        try {
            roomBiz.checkReserve(reserveVo);
            roomBiz.reserve(reserveVo);
            return "预定成功";
        } catch (ManageException e) {
            logger.info("submitReserve error:{}", e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            logger.error("submitReserve error:", e);
            return "预定失败";
        }


    }

    @RequestMapping(value = "/toCancelReserve", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String toCancelReserve(@RequestParam("id") Long id) {
        try {
            roomBiz.checkCancelReserve(id);
            roomBiz.cancelReserve(id);
            return "取消成功";
        } catch (ManageException e) {
            logger.info("toCancelReserve error:{}", e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            logger.error("toCancelReserve error:", e);
            return "处理失败";
        }
    }

}
