package swa.manage.mapper;


import swa.manage.entity.RoomRecord;

/**
 * RoomRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomRecordMapper {

    public void add(RoomRecord roomRecord);

    public void update(RoomRecord roomRecord);

    public void deleteByPriKey(Long id);

    public RoomRecord queryByPriKey(Long id);

}