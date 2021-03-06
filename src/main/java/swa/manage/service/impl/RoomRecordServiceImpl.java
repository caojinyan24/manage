package swa.manage.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.entity.RoomRecord;
import swa.manage.mapper.RoomRecordMapper;
import swa.manage.service.RoomRecordService;
import swa.manage.value.TimePeriodEnum;
import swa.manage.value.ValidEnum;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * RoomRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Service("roomRecordService")
public class RoomRecordServiceImpl implements RoomRecordService {
    private static final Logger logger = LoggerFactory.getLogger(RoomRecordServiceImpl.class);

    @Resource
    private RoomRecordMapper roomRecordMapper;

    @Override
    public void deleteByPriKey(Long id) {
        roomRecordMapper.deleteByPriKey(id);
    }

    @Override
    public RoomRecord queryByPriKey(Long id) {
        return roomRecordMapper.queryByPriKey(id);
    }

    @Override
    public List<RoomRecord> queryRoomRecord(Date queryDate, Long configId) {
        return roomRecordMapper.queryRoomRecord(queryDate, configId);
    }

    @Override
    public void insertInitRecord(Date date, Long configId) {
        roomRecordMapper.insertInitRecord(TimePeriodEnum.getAsMap().keySet(), date, configId);
    }

    @Override
    public List<RoomRecord> queryRoomRecord(Date queryDate) {
        return roomRecordMapper.queryRoomRecord(queryDate, null);
    }

    @Override
    public void updatevalidStatus(ValidEnum newValidStatus, List<TimePeriodEnum> timePeriod, Date date, Long configId) {
        roomRecordMapper.updateValidStatus(newValidStatus, timePeriod, date, configId);
    }

    @Override
    public List<RoomRecord> queryRoomRecord(ValidEnum currentValidStatus, List<TimePeriodEnum> timePeriods, Date date, Long configId) {
        return roomRecordMapper.querySpecifiedRecord(currentValidStatus, timePeriods, date, configId);
    }


}
