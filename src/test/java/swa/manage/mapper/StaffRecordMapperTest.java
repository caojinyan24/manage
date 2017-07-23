package swa.manage.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import swa.manage.entity.StaffRecord;
import swa.manage.value.ValidEnum;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by jinyan on 7/17/17 6:13 PM.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffRecordMapperTest {
    @Resource
    private StaffRecordMapper staffRecordMapper;

    @Test
    public void testAdd() throws Exception {
        StaffRecord staffRecord = new StaffRecord();
        staffRecord.setComment("test-comment");
        staffRecord.setDate(new Date());
        staffRecord.setConfigId(1L);
        staffRecord.setReserveTime("1,2");
        staffRecord.setStaffName("abc");
        staffRecord.setValidStatus(ValidEnum.VALID);
        staffRecordMapper.add(staffRecord);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDeleteByPriKey() throws Exception {

    }

    @Test
    public void testQueryByPriKey() throws Exception {

    }

    @Test
    public void testQueryStaffRecord() throws Exception {

    }
}