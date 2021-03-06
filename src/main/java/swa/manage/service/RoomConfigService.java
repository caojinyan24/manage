package swa.manage.service;


import swa.manage.entity.RoomConfig;
import swa.manage.value.ValidEnum;

import java.util.List;

/**
 * RoomConfigService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomConfigService {

    void add(RoomConfig roomConfig);

    List<RoomConfig> queryConfig(RoomConfig roomConfig);

    List<RoomConfig> queryValidConfig(RoomConfig roomConfig);

    void updateValidStatus(Long id, ValidEnum validStatus);


}

