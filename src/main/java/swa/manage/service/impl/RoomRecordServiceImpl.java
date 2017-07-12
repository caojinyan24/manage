package swa.manage.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.entity.RoomRecord;
import swa.manage.mapper.RoomRecordMapper;
import swa.manage.service.RoomRecordService;

import javax.annotation.Resource;

/**
 * RoomRecordService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Service("roomRecordService")
public class RoomRecordServiceImpl implements RoomRecordService {
    private static final Logger logger = LoggerFactory.getLogger(RoomRecordServiceImpl.class);

//    @Resource
//    private RoomRecordMapper roomRecordMapper;


    @Override
    public void add(RoomRecord roomRecord) {

    }

    @Override
    public void update(RoomRecord roomRecord) {

    }

    @Override
    public void deleteByPriKey(Long id) {

    }

    @Override
    public RoomRecord queryByPriKey(Long id) {
        return null;
    }
}
