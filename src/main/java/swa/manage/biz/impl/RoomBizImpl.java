package swa.manage.biz.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import swa.manage.biz.RoomBiz;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;
import swa.manage.entity.vo.RecordInfoVo;
import swa.manage.entity.vo.SearchVo;
import swa.manage.service.RoomConfigService;
import swa.manage.service.RoomRecordService;
import swa.manage.service.StaffRecordService;
import swa.manage.value.ReserveVo;
import swa.manage.value.ValidEnum;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jinyan on 7/14/17.
 */
@Service
public class RoomBizImpl implements RoomBiz {
    private static final Logger logger = LoggerFactory.getLogger(RoomBizImpl.class);
    @Resource
    private RoomConfigService roomConfigService;
    @Resource
    private RoomRecordService roomRecordService;
    @Resource
    private StaffRecordService staffRecordService;

    @Override
    public List<RecordInfoVo> queryAndInitRecords(SearchVo searchVo) {
        List<RecordInfoVo> result = Lists.newArrayList();
        List<RoomConfig> roomConfigs = roomConfigService.queryConfig(new RoomConfig(searchVo));
        for (RoomConfig roomConfig : roomConfigs) {
            List<RoomRecord> records = roomRecordService.queryRoomRecord(searchVo.getDate(), roomConfig.getId());
            if (CollectionUtils.isEmpty(records)) {
                roomRecordService.insertInitRecord(searchVo.getDate(), roomConfig.getId());
                records = roomRecordService.queryRoomRecord(searchVo.getDate(), roomConfig.getId());

            }
            result.add(new RecordInfoVo(roomConfig, records));

        }
        return result;
    }

    @Override
    @Transactional
    public void reserve(ReserveVo reserveVo) {
        //roomrecord修改状态
        roomRecordService.updatevalidStatus(ValidEnum.INVALID, reserveVo.getTimePeriods(), reserveVo.getReserveDate(), reserveVo.getConfigId());
        //添加staffrecord记录
        staffRecordService.add(ReserveVo.assembleStaffRecord(reserveVo));
    }

//    @Override
//    public Map<String, RoomConfig> getConfigMap() {
//
//        Map<String, RoomConfig> result = Maps.newHashMap();
//        List<RoomConfig> configs = roomConfigService.queryConfig();
//
//        for (RoomConfig config : configs) {
//            result.put(config.getEncode(), config);
//        }
//        return result;
//
//
//    }
}
