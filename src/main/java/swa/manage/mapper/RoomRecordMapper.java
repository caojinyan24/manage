package swa.manage.mapper;


import swa.manage.entity.RoomRecord;

import java.util.List;

/**
 * RoomRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomRecordMapper {

    void add(RoomRecord roomRecord);

    void update(RoomRecord roomRecord);

    void deleteByPriKey(Long id);

    RoomRecord queryByPriKey(Long id);

    List<RoomRecord> queryRoomRecord();

}