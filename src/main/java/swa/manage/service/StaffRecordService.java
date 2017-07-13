package swa.manage.service;


import swa.manage.entity.StaffRecord;

import java.util.List;

/**
 * StaffRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface StaffRecordService {

    public void add(StaffRecord staffRecord);

    public void update(StaffRecord staffRecord);

    public void deleteByPriKey(Long id);

    public StaffRecord queryByPriKey(Long id);

    List<StaffRecord>queryStaffRecord();

}

