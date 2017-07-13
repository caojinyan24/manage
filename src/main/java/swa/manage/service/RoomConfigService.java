package swa.manage.service;


import swa.manage.entity.RoomConfig;

import java.util.List;

/**
 * RoomConfigService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomConfigService {

    void add(RoomConfig roomConfig);

    void update(RoomConfig roomConfig);

    void deleteByPriKey(Long id);

    List<RoomConfig> queryConfig();

    RoomConfig queryById(Long id);

}

