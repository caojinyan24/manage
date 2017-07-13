package swa.manage.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.entity.RoomRecord;
import swa.manage.service.RoomRecordService;

import javax.servlet.http.HttpServletRequest;

/**
 * RoomRecordController  会议室预定记录表
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Controller
@RequestMapping("/roomRecord")
public class RoomRecordController {

    private static final Logger logger = LoggerFactory.getLogger(RoomRecordController.class);
    @Autowired
    private RoomRecordService roomRecordService;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping(value = "roomRecordIndex", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roomRecordIndex(@ModelAttribute RoomRecord query,
                                        @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
                                        @RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) {

        ModelAndView mav = new ModelAndView("roomRecord/roomRecordIndex");
        mav.addObject("datas", roomRecordService.queryRoomRecord());
        return mav;
    }

    /**
     * 详情
     *
     * @return
     */
    @RequestMapping(value = "roomRecordDetail", method = RequestMethod.GET)
    public ModelAndView roomRecordDetail(@RequestParam(required = true, value = "id") Long id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("roomRecord/roomRecordDetail");
        RoomRecord roomRecord = roomRecordService.queryByPriKey(id);
        mav.addObject("roomRecord", roomRecord);
        return mav;

    }

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddDialog", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddDialog(HttpServletRequest request, ModelMap model) {
        return "roomRecord/roomRecordAddDialog";
    }

//    /**
//     * 保存信息
//     *
//     * @return
//     */
//    @RequestMapping(value = "/roomRecordAdd", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson roomRecordAdd(@ModelAttribute RoomRecord roomRecord) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomRecordService.add(roomRecord);
//            j.setMsg("保存成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("保存失败");
//        }
//        return j;
//    }

//    /**
//     * 跳转到编辑页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "toEditDialog", method = RequestMethod.GET)
//    public ModelAndView toEditDialog(@RequestParam(required = true, value = "id") Long id) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("pay/roomRecordEditDialog");
//        RoomRecord roomRecord = roomRecordService.queryByPriKey(id);
//        mav.addObject("roomRecord", roomRecord);
//        return mav;
//    }
//
//    /**
//     * 编辑
//     *
//     * @return
//     */
//    @RequestMapping(value = "/roomRecordEdit", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson roomRecordEdit(@ModelAttribute RoomRecord roomRecord) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomRecordService.update(roomRecord);
//            j.setMsg("编辑成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("编辑失败");
//        }
//        return j;
//    }
//
//
//    /**
//     * 删除
//     *
//     * @return
//     */
//    @RequestMapping(value = "roomRecordDelete", method = RequestMethod.GET)
//    @ResponseBody
//    public AjaxJson roomRecordDelete(@RequestParam(required = true, value = "id") Long id) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomRecordService.deleteByPriKey(id);
//            j.setMsg("删除成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("删除失败");
//        }
//        return j;
//    }


}

