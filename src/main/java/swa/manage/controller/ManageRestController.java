package swa.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinyan on 7/16/17.
 */
@RequestMapping("manage")
@RestController
public class ManageRestController {
    private static final Logger logger = LoggerFactory.getLogger(ManageRestController.class);

    @RequestMapping("reserveSubmit")
    public String submitReserve(@RequestParam("date") String date, @RequestParam("encode") String encode, @RequestParam("timePeriods") String timePeriodsStr,
                                @RequestParam("reserveReason") String reserveReason, @RequestParam("name") String name, @RequestParam("phone") String phone) {
        // TODO: 7/16/17
        // TODO: 7/16/17 插入记录到stffrecord
        // 添加记录到roomrecord
        return "预定成功";
    }
}
