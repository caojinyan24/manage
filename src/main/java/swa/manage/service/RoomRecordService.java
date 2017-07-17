package swa.manage.service;


import swa.manage.value.TimePeriodEnum;
import swa.manage.entity.RoomRecord;
import swa.manage.value.ValidEnum;

import java.util.Date;
import java.util.List;

/**
 * RoomRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomRecordService {

    public void deleteByPriKey(Long id);

    public RoomRecord queryByPriKey(Long id);

    List<RoomRecord> queryRoomRecord(Date queryDate, String encode);

    void insertInitRecord(Date date, String encode);

    List<RoomRecord> queryRoomRecord(Date queryDate);

    void updatevalidStatus(ValidEnum newValidStatus, List<TimePeriodEnum> timePeriod, Date date, String encode);


}

