package swa.manage.biz.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import swa.manage.biz.RoomBiz;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;
import swa.manage.service.RoomConfigService;
import swa.manage.service.RoomRecordService;
import swa.manage.service.StaffRecordService;
import swa.manage.value.ReserveVo;
import swa.manage.value.ValidEnum;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<RoomRecord>> queryAndInitRecords(Date queryDate) {
        Map<String, List<RoomRecord>> result = Maps.newLinkedHashMap();// TODO: 7/14/17 优化
        List<RoomConfig> config = roomConfigService.queryConfig();
        List<String> encodes = Lists.transform(config, new Function<RoomConfig, String>() {
            @Nullable
            @Override
            public String apply(@Nullable RoomConfig roomConfig) {
                return roomConfig.getEncode();
            }
        });
        logger.debug("assembleRecords.encodes:{}", encodes);
        for (String encode : Sets.newHashSet(encodes)) {

            List<RoomRecord> records = roomRecordService.queryRoomRecord(queryDate, encode);
            if (CollectionUtils.isEmpty(records)) {
                roomRecordService.insertInitRecord(queryDate, encode);
                records = roomRecordService.queryRoomRecord(queryDate, encode);
            }
            result.put(encode, records);

        }

        return result;
    }

    @Override
    @Transactional
    public void reserve(ReserveVo reserveVo) {
        //roomrecord修改状态
        roomRecordService.updatevalidStatus(ValidEnum.INVALID, reserveVo.getTimePeriods(), reserveVo.getReserveDate(), reserveVo.getEncode());
        //添加staffrecord记录
        staffRecordService.add(ReserveVo.assembleStaffRecord(reserveVo));
    }


}
