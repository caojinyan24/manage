package swa.manage.mapper;

import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringRunner;
import swa.manage.common.TimePeriodEnum;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by jinyan on 7/14/17.
 */
@RunWith(SpringRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class RoomRecordMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(RoomRecordMapperTest.class);
    @Resource
    private RoomRecordMapper roomRecordMapper;

    @Test
    public void testInsertInitRecord() throws Exception {
        roomRecordMapper.insertInitRecord(TimePeriodEnum.getAsMap().keySet(), new Date(), "abc");
        logger.info("##", roomRecordMapper.queryRoomRecord(new Date(), "abc"));

    }

    @Test
    public void testQueryRoomRecord() throws Exception {
        logger.info("##{}", roomRecordMapper.queryRoomRecord(DateUtil.truncateTime(new Date()), "abc"));
    }
}