package swa.manage.mapper;


import swa.manage.entity.StaffRecord;

import java.util.List;

/**
 * StaffRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface StaffRecordMapper {

    void add(StaffRecord staffRecord);

    void update(StaffRecord staffRecord);

     void deleteByPriKey(Long id);

     StaffRecord queryByPriKey(Long id);

    List<StaffRecord> queryStaffRecord();

}