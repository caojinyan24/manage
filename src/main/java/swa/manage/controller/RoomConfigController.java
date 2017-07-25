package swa.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import swa.manage.entity.RoomConfig;
import swa.manage.service.RoomConfigService;
import swa.manage.value.ValidEnum;

import java.util.List;

/**
 * RoomConfigController  配置表
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Controller
@RequestMapping("/roomConfig")
public class RoomConfigController {

    private static final Logger logger = LoggerFactory.getLogger(RoomConfigController.class);
    @Autowired
    private RoomConfigService roomConfigService;

    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping("/roomConfigIndex")
    public String roomConfigIndex(Model model) {
        List<RoomConfig> roomConfigs = roomConfigService.queryConfig(new RoomConfig());
        model.addAttribute("datas", roomConfigs);
        logger.info("roomConfig:{}", roomConfigs);
        return "roomConfig/roomConfigIndex";


    }


    @RequestMapping(value = "stopReserve")
    @ResponseBody
    public String stopReserve(@RequestParam(required = true, value = "id") Long id) {
        try {
            roomConfigService.updateValidStatus(id, ValidEnum.INVALID);
            return "操作成功";
        } catch (Exception e) {
            return "操作失败";
        }
    }

    @RequestMapping(value = "reReserve")
    @ResponseBody
    public String reReserve(@RequestParam(required = true, value = "id") Long id) {
        try {
            roomConfigService.updateValidStatus(id, ValidEnum.VALID);
            return "操作成功";
        } catch (Exception e) {
            return "操作失败";
        }
    }

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddDialog")
    public String toAddDialog() {
        return "roomConfig/roomConfigAddDialog";
    }

    /**
     * 保存信息
     *
     * @return
     */
    @RequestMapping(value = "/roomConfigAdd", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String roomConfigAdd(@ModelAttribute RoomConfig roomConfig) {
        try {
            roomConfig.setValidStatus(ValidEnum.VALID);
            roomConfigService.add(roomConfig);
            return "保存成功";
        } catch (Exception e) {
            logger.error("roomConfigAdd error:", e);
            return "保存失败";
        }
    }

//    /**
//     * 跳转到编辑页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "toEditDialog", method = RequestMethod.GET)
//    public String toEditDialog(@RequestParam(required = true, value = "id") Long id, Model model) {
//        RoomConfig roomConfig = roomConfigService.queryById(id);
//        model.addAttribute("roomConfig", roomConfig);
//        return "roomConfig/roomConfigEditDialog";
//    }
//
//    /**
//     * 编辑
//     *
//     * @return
//     */
//    @RequestMapping(value = "/roomConfigEdit", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String roomConfigEdit(@ModelAttribute RoomConfig roomConfig) {
//        try {
//            roomConfigService.update(roomConfig);
//            return "编辑成功";
//        } catch (Exception e) {
//            logger.error("roomConfigEdit error:", e);
//            return "编辑失败";
//        }
//    }

//
//    /**
//     * 删除
//     *
//     * @return
//     */
//    @RequestMapping(value = "roomConfigDelete")
//    @ResponseBody
//    public String roomConfigDelete(@RequestParam(required = true, value = "id") Long id) {
//        try {
//            roomConfigService.deleteByPriKey(id);
//            return "删除成功";
//        } catch (Exception e) {
//            logger.error("roomConfigDelete error:", e);
//            return "删除失败";
//        }
//    }


}

