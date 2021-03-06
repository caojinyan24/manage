package swa.manage.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import swa.manage.entity.RoomRecord;
import swa.manage.value.TimePeriodEnum;
import swa.manage.value.ValidEnum;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * RoomRecordMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Repository
public interface RoomRecordMapper {

    void insertInitRecord(@Param("times") Set<Integer> times, @Param("date") Date date, @Param("configId") Long configId);

    void deleteByPriKey(Long id);

    RoomRecord queryByPriKey(Long id);

    List<RoomRecord> queryRoomRecord(@Param("queryDate") Date queryDate, @Param("configId") Long configId);

    void updateValidStatus(@Param("newValidStatus") ValidEnum newValidStatus, @Param("timePeriods") List<TimePeriodEnum> timePeriods, @Param("date") Date date, @Param("configId") Long configId);

    List<RoomRecord> querySpecifiedRecord(@Param("validStatus") ValidEnum validStatus, @Param("timePeriods") List<TimePeriodEnum> timePeriods, @Param("date") Date date, @Param("configId") Long configId);
}