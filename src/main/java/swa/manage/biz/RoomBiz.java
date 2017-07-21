package swa.manage.biz;

import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;
import swa.manage.value.ReserveVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jinyan on 7/14/17.
 */
public interface RoomBiz {

    Map<String, List<RoomRecord>> queryAndInitRecords(Date queryDate);

    void reserve(ReserveVo reserveVo);

    public Map<String, RoomConfig> getConfigMap();

}
