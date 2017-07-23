package swa.manage.common;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import swa.manage.entity.RoomConfig;
import swa.manage.mapper.RoomConfigMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jinyan on 7/23/17 10:00 PM.
 */
@Component
public class CacheInfoUtil {
    private static final Logger logger = LoggerFactory.getLogger(CacheInfoUtil.class);
    private static Set<String> cities = Sets.newHashSet();
    private static Map<String, Set<String>> regionMap = Maps.newHashMap();
    private static Map<Long, RoomConfig> roomConfigMap = Maps.newHashMap();
    // TODO: 7/23/17 更新之后需要更新缓存
    @Resource
    private RoomConfigMapper roomConfigMapper;


    @PostConstruct
    public void setUp() {
        List<RoomConfig> roomConfigs = roomConfigMapper.queryConfig(new RoomConfig());
        for (RoomConfig roomConfig : roomConfigs) {
            cities.add(roomConfig.getCity());
            if (regionMap.get(roomConfig.getCity()) == null) {
                regionMap.put(roomConfig.getCity(), Sets.newHashSet());
            }
            regionMap.get(roomConfig.getCity()).add(roomConfig.getRegion());
            roomConfigMap.put(roomConfig.getId(), roomConfig);
        }
        logger.info("{},{},{}", cities, regionMap, roomConfigs);
    }


    public Map<Long, RoomConfig> getRoomConfigMap() {
        return roomConfigMap;
    }


    public void setRoomConfigMap(Map<Long, RoomConfig> roomConfigMap) {
        roomConfigMap = roomConfigMap;
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        CacheInfoUtil.cities = cities;
    }

    public Set<String> getRegions(String city) {
        return regionMap.get(city);
    }

    public Map<String, Set<String>> getRegionMap() {
        return regionMap;
    }

    public void setRegionMap(Map<String, Set<String>> regionMap) {
        CacheInfoUtil.regionMap = regionMap;
    }
}
