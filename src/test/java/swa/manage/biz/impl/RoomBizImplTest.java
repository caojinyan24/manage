package swa.manage.biz.impl;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringRunner;
import swa.manage.biz.RoomBiz;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jinyan on 7/16/17.
 */
@RunWith(SpringRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class RoomBizImplTest {
    @Resource
    private RoomBiz roomBiz;

    @Test
    public void testAssembleRecords() throws Exception {
        roomBiz.queryAndInitRecords(DateUtils.truncate(new Date(), Calendar.DATE));
    }
}