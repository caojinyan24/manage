package swa.manage.service;


import swa.manage.entity.RoomRecord;

/**
 * RoomRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomRecordService {

    public void add(RoomRecord roomRecord);

    public void update(RoomRecord roomRecord);

    public void deleteByPriKey(Long id);

    public RoomRecord queryByPriKey(Long id);

}

