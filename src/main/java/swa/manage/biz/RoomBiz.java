package swa.manage.biz;

import swa.manage.entity.vo.RecordInfoVo;
import swa.manage.entity.vo.SearchVo;
import swa.manage.value.ReserveVo;

import java.util.List;

/**
 * Created by jinyan on 7/14/17.
 */
public interface RoomBiz {

    List<RecordInfoVo> queryAndInitRecords(SearchVo searchVo);

    void reserve(ReserveVo reserveVo);

    void cancelReserve(Long configId);


}
