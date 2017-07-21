package swa.manage.controller;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.biz.RoomBiz;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;
import swa.manage.value.TimePeriodEnum;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Resource
    private RoomBiz roomBiz;

    /**
     * 查询指定日期所有房间的预定情况（默认查询当天的）
     *
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView roomRecordIndex(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "date", required = false) Date date) {
        logger.info("roomRecordIndex-begin:{}", date);
        ModelAndView mav = new ModelAndView("roomReserve/index");
        try {
            if (null == date) {
                date = DateUtils.truncate(new Date(), Calendar.DATE);
            }
            Map<String, List<RoomRecord>> records = roomBiz.queryAndInitRecords(date);
            mav.addObject("records", records);
            mav.addObject("configs",roomBiz.getConfigMap());
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap());
            mav.addObject("date", date);

        } catch (Exception e) {
            mav.addObject("records", Maps.newHashMap());
            mav.addObject("timePeriods", TimePeriodEnum.getAsMap().keySet());
            mav.addObject("date", DateUtils.truncate(new Date(), Calendar.DATE));
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
    public ModelAndView roomReserve(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date,
                                    @RequestParam("encode") String encode,
                                    @RequestParam("timePeriods") String timePeriodsStr) {
        ModelAndView mav = new ModelAndView("roomReserve/reserve");
        logger.info("roomReserve-begin:{},{},{}", date, encode, timePeriodsStr);
        try {
            mav.addObject("room", roomBiz.getConfigMap().get(encode));
            mav.addObject("date", date);
            mav.addObject("timePeriods", timePeriodsStr);
            mav.addObject("showTime",getShowTime(timePeriodsStr));
        } catch (Exception e) {
            mav.addObject("records", Maps.newHashMap());
            mav.addObject("date", date);
            mav.addObject("timePeriods", timePeriodsStr);
            logger.error("roomReserve error", e);
        }
        logger.info("roomReserve-end:{}", mav.getModel());
        return mav;
    }

    private String getShowTime(String str){// TODO: 7/21/17 合并时间段 
        List<String>list= Splitter.on(",").omitEmptyStrings().splitToList(str);
        StringBuilder sb=new StringBuilder("");
        for(String s:list){
            sb.append(',').append(TimePeriodEnum.getAsMap().get(Integer.valueOf(s)));
        }
        return sb.toString().substring(1);
    }


}
