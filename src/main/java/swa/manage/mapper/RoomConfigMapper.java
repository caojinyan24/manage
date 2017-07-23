package swa.manage.mapper;


import swa.manage.entity.RoomConfig;

import java.util.List;

/**
 * RoomConfigMapper
 * Created by jinyan.cao on 2017-07-23 21:38:44
 */
public interface RoomConfigMapper {

    void addConfig(RoomConfig roomConfig);

    List<RoomConfig> queryConfig(RoomConfig roomConfig);

}