package swa.manage.mapper;


import swa.manage.entity.StaffRecord;

import java.util.List;

/**
 * StaffRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface StaffRecordMapper {

    public void add(StaffRecord staffRecord);

    public void update(StaffRecord staffRecord);

    public void deleteByPriKey(Long id);

    public StaffRecord queryByPriKey(Long id);

    List<StaffRecord> queryStaffRecord();

}