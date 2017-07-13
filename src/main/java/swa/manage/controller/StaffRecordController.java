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
import swa.manage.entity.StaffRecord;
import swa.manage.service.StaffRecordService;

import javax.servlet.http.HttpServletRequest;

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
        mav.addObject("datas", staffRecordService.queryStaffRecord());
        return mav;
    }

    /**
     * 详情
     *
     * @return
     */
    @RequestMapping(value = "staffRecordDetail", method = RequestMethod.GET)
    public ModelAndView staffRecordDetail(@RequestParam(required = true, value = "id") Long id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("staffRecord/staffRecordDetail");
        StaffRecord staffRecord = staffRecordService.queryByPriKey(id);
        mav.addObject("staffRecord", staffRecord);
        return mav;
    }

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddDialog", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddDialog(HttpServletRequest request, ModelMap model) {
        return "staffRecord/staffRecordAddDialog";
    }

//    /**
//     * 保存信息
//     *
//     * @return
//     */
//    @RequestMapping(value = "/staffRecordAdd", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson staffRecordAdd(@ModelAttribute StaffRecord staffRecord) {
//        AjaxJson j = new AjaxJson();
//        try {
//            staffRecordService.add(staffRecord);
//            j.setMsg("保存成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("保存失败");
//        }
//        return j;
//    }
//
//    /**
//     * 跳转到编辑页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "toEditDialog", method = RequestMethod.GET)
//    public ModelAndView toEditDialog(@RequestParam(required = true, value = "id") Long id) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("pay/staffRecordEditDialog");
//        StaffRecord staffRecord = staffRecordService.queryByPriKey(id);
//        mav.addObject("staffRecord", staffRecord);
//        return mav;
//    }
//
//    /**
//     * 编辑
//     *
//     * @return
//     */
//    @RequestMapping(value = "/staffRecordEdit", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson staffRecordEdit(@ModelAttribute StaffRecord staffRecord) {
//        AjaxJson j = new AjaxJson();
//        try {
//            staffRecordService.update(staffRecord);
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
//    @RequestMapping(value = "staffRecordDelete", method = RequestMethod.GET)
//    @ResponseBody
//    public AjaxJson staffRecordDelete(@RequestParam(required = true, value = "id") Long id) {
//        AjaxJson j = new AjaxJson();
//        try {
//            staffRecordService.deleteByPriKey(id);
//            j.setMsg("删除成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("删除失败");
//        }
//        return j;
//    }


}

