package swa.manage.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.biz.RoomBiz;
import swa.manage.value.TimePeriodEnum;
import swa.manage.entity.RoomRecord;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jinyan on 7/14/17.
 */
@RequestMapping("manage")
@Controller
public class ManageController {
    private static final Logger logger = LoggerFactory.getLogger(RoomRecordController.class);
    @Resource
    private RoomBiz roomBiz;

    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "index", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roomRecordIndex(@RequestParam(value = "date", required = false, defaultValue = "") String dateStr) {
        ModelAndView mav = new ModelAndView("roomReserve/index");
        try {
            Date date;
            if (Strings.isNullOrEmpty(dateStr)) {
                date = DateUtils.truncate(new Date(), Calendar.DATE);
            } else {
                date = DateUtils.parseDate(dateStr, (String[]) Lists.newArrayList("yyyy-MM-dd").toArray());
            }
            Map<String, List<RoomRecord>> records = roomBiz.queryAndInitRecords(date);
            mav.addObject("records", records);
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap().keySet());
            mav.addObject("date", DateFormatUtils.format(date, "yyyy-MM-dd"));
        } catch (Exception e) {
            mav.addObject("records", Maps.newHashMap());
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap().keySet());
            mav.addObject("date", dateStr);
            logger.error("roomRecordIndex error", e);
        }
        logger.info("roomRecordIndex-end:{}", mav.getModel());
        return mav;
    }

    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "reserve", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roomReserve(@RequestParam("date") String dateStr,
                                    @RequestParam("encode") String encode,
                                    @RequestParam("timePeriods") String timePeriodsStr) {
        ModelAndView mav = new ModelAndView("roomReserve/reserve");
        logger.info("roomReserve-begin:{},{},{}", dateStr, encode, timePeriodsStr);
        try {
            mav.addObject("encode", encode);
            mav.addObject("date", dateStr);
            mav.addObject("timePeriods", timePeriodsStr);
        } catch (Exception e) {
            mav.addObject("records", Maps.newHashMap());
            mav.addObject("date", dateStr);
            mav.addObject("timePeriods", timePeriodsStr);
            logger.error("roomRecordIndex error", e);
        }
        logger.info("roomReserve-end:{}", mav.getModel());
        return mav;
    }


}
