package swa.manage.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.entity.RoomConfig;
import swa.manage.mapper.RoomConfigMapper;
import swa.manage.service.RoomConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * RoomConfigService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
@Service("roomConfigService")
public class RoomConfigServiceImpl implements RoomConfigService {
    private static final Logger logger = LoggerFactory.getLogger(RoomConfigServiceImpl.class);
    @Resource
    private RoomConfigMapper roomConfigMapper;


    @Override
    public void add(RoomConfig roomConfig) {
        roomConfigMapper.add(roomConfig);
    }

    @Override
    public void update(RoomConfig roomConfig) {
        roomConfigMapper.update(roomConfig);
    }

    @Override
    public void deleteByPriKey(Long id) {
        roomConfigMapper.deleteByPriKey(id);
    }

    @Override
    public List<RoomConfig> queryConfig() {
        return roomConfigMapper.queryConfig();
    }

    @Override
    public RoomConfig queryById(Long id) {
        return roomConfigMapper.queryById(id);
    }
}
