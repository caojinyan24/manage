package swa.manage.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import swa.manage.entity.RoomRecord;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * RoomRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Repository
public interface RoomRecordMapper {

    void insertInitRecord(@Param("times") Set<Integer> times, @Param("date") Date date, @Param("encode") String encode);

    void update(RoomRecord roomRecord);

    void deleteByPriKey(Long id);

    RoomRecord queryByPriKey(Long id);

    List<RoomRecord> queryRoomRecord(@Param("queryDate") Date queryDate, @Param("encode") String encode);

}