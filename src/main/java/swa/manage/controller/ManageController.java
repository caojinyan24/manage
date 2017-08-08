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
import org.springframework.web.servlet.view.RedirectView;
import swa.manage.biz.RoomBiz;
import swa.manage.common.CacheInfoUtil;
import swa.manage.common.CommonServiceUtil;
import swa.manage.common.ManageException;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.vo.RecordInfoVo;
import swa.manage.entity.vo.SearchVo;
import swa.manage.service.RoomConfigService;
import swa.manage.service.StaffVerifyService;
import swa.manage.value.ReserveVo;
import swa.manage.value.TimePeriodEnum;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jinyan on 7/14/17.
 */
@RequestMapping("manage")
@Controller
public class ManageController {
    private static final Logger logger = LoggerFactory.getLogger(RoomRecordController.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    private StaffVerifyService staffVerifyService;


    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "login")
    public ModelAndView roomRecordIndex() {
        //todo:校验是否登录,若未登录,重定向到登录页面
        return new ModelAndView("common/login");
    }

    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView roomRecordIndex(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password) {

        if (staffVerifyService.isValidUser(userName, password)) {
            return new ModelAndView(new RedirectView("/reserve/roomReserveIndex"));
        } else {
            logger.error("invalid user info");
            return new ModelAndView("common/login");
        }
    }




}
