package swa.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.common.CacheInfoUtil;
import swa.manage.entity.StaffRecord;
import swa.manage.service.StaffRecordService;
import swa.manage.value.StaffRecordVo;

import javax.annotation.Resource;

/**
 * StaffRecordController  人员预定记录表
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Controller
@RequestMapping("/staffRecord")
public class StaffRecordController {

    private static final Logger logger = LoggerFactory.getLogger(StaffRecordController.class);
    @Autowired
    private StaffRecordService staffRecordService;
    @Resource
    private CacheInfoUtil cacheInfoUtil;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping(value = "staffRecordIndex", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView staffRecordIndex(@ModelAttribute StaffRecord query,
                                         @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
                                         @RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) {

        ModelAndView mav = new ModelAndView("staffRecord/staffRecordIndex");
        mav.addObject("datas", StaffRecordVo.convert(staffRecordService.queryStaffRecordDesc()));
        logger.info("staffRecordIndex-end:{}", mav.getModel());
        return mav;
    }


}

