package swa.manage.biz;

import swa.manage.entity.RoomRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jinyan on 7/14/17.
 */
public interface RoomBiz {

    Map<String, List<RoomRecord>> assembleRecords(Date queryDate);
}
