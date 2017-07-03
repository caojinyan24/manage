package swa.manage.mapper;


import swa.manage.entity.RoomConfig;

import java.util.List;

/**
 * RoomConfigMapper
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomConfigMapper {

    void add(RoomConfig roomConfig);

    void update(RoomConfig roomConfig);

    void deleteByPriKey(Long id);

    List<RoomConfig> queryConfig();

}