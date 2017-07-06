package swa.manage.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import swa.manage.entity.RoomConfig;
import swa.manage.service.RoomConfigService;

import java.util.List;

/**
 * RoomConfigController  配置表
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Controller
@RequestMapping("/roomConfig")
@EnableAutoConfiguration
public class RoomConfigController {

    private static final Logger logger = LoggerFactory.getLogger(RoomConfigController.class);
    @Autowired
    private RoomConfigService roomConfigService;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping(value = "roomConfigIndex", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView roomConfigIndex(@ModelAttribute RoomConfig query,
                                        @RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
                                        @RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("roomConfig/roomConfigIndex");
        List<RoomConfig> roomConfigs = roomConfigService.queryConfig();
        modelAndView.addObject("datas", roomConfigs);
        logger.info("roomConfig:{}", roomConfigs);
        return modelAndView;
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
//        return "test hello world";
        return "roomConfig/roomConfigIndex";
    }

    /**
     * 详情
     *
     * @return
     */
    @RequestMapping(value = "roomConfigDetail", method = RequestMethod.GET)
    public ModelAndView roomConfigDetail(@RequestParam(required = true, value = "id") Long id) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("pay/roomConfigDetail");
//        RoomConfig roomConfig = roomConfigService.queryByPriKey(id);
//        mav.addObject("roomConfig", roomConfig);
//        return mav;
        return null;
    }

//    /**
//     * 跳转到添加页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "/toAddDialog", method = {RequestMethod.GET, RequestMethod.POST})
//    public String toAddDialog(HttpServletRequest request, ModelMap model) {
//        return "pay/roomConfigAddDialog";
//    }
//
//    /**
//     * 保存信息
//     *
//     * @return
//     */
//    @RequestMapping(value = "/roomConfigAdd", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson roomConfigAdd(@ModelAttribute RoomConfig roomConfig) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomConfigService.add(roomConfig);
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
//        mav.setViewName("pay/roomConfigEditDialog");
//        RoomConfig roomConfig = roomConfigService.queryByPriKey(id);
//        mav.addObject("roomConfig", roomConfig);
//        return mav;
//    }
//
//    /**
//     * 编辑
//     *
//     * @return
//     */
//    @RequestMapping(value = "/roomConfigEdit", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public AjaxJson roomConfigEdit(@ModelAttribute RoomConfig roomConfig) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomConfigService.update(roomConfig);
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
//    @RequestMapping(value = "roomConfigDelete", method = RequestMethod.GET)
//    @ResponseBody
//    public AjaxJson roomConfigDelete(@RequestParam(required = true, value = "id") Long id) {
//        AjaxJson j = new AjaxJson();
//        try {
//            roomConfigService.deleteByPriKey(id);
//            j.setMsg("删除成功");
//        } catch (Exception e) {
//            j.setSuccess(false);
//            j.setMsg("删除失败");
//        }
//        return j;
//    }
//

}

