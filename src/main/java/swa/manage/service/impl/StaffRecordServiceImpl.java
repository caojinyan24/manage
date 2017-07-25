package swa.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.entity.StaffRecord;
import swa.manage.mapper.StaffRecordMapper;
import swa.manage.service.StaffRecordService;

import javax.annotation.Resource;
import java.util.List;

/**
 * StaffRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Service
public class StaffRecordServiceImpl implements StaffRecordService {
    private static final Logger logger = LoggerFactory.getLogger(StaffRecord.class);

    @Resource
    private StaffRecordMapper staffRecordMapper;


    @Override
    public void add(StaffRecord staffRecord) {
        staffRecordMapper.add(staffRecord);
    }

    @Override
    public void updateById(StaffRecord staffRecord) {
        staffRecordMapper.updateById(staffRecord);
    }

    @Override
    public void deleteByPriKey(Long id) {
        staffRecordMapper.deleteByPriKey(id);
    }

    @Override
    public StaffRecord queryByPriKey(Long id) {
        return staffRecordMapper.queryByPriKey(id);
    }

    @Override
    public List<StaffRecord> queryStaffRecordDesc() {
        return staffRecordMapper.queryStaffRecordDesc();
    }
}
