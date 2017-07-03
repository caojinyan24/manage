package swa.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.entity.StaffRecord;
import swa.manage.mapper.StaffRecordMapper;
import swa.manage.service.StaffRecordService;

import javax.annotation.Resource;

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

    }

    @Override
    public void update(StaffRecord staffRecord) {

    }

    @Override
    public void deleteByPriKey(Long id) {

    }

    @Override
    public StaffRecord queryByPriKey(Long id) {
        return null;
    }
}
