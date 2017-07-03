package swa.manage.service;


import swa.manage.entity.RoomConfig;

/**
 * RoomConfigService
 * Created by jinyan.cao on 2017-07-03 17:47:53
 */
public interface RoomConfigService {

    public void add(RoomConfig roomConfig);

    public void update(RoomConfig roomConfig);

    public void deleteByPriKey(Long id);

    public RoomConfig queryByPriKey(Long id);

}

