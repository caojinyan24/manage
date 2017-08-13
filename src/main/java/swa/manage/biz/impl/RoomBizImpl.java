package swa.manage.biz.impl;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import swa.manage.biz.RoomBiz;
import swa.manage.common.CommonServiceUtil;
import swa.manage.common.ManageException;
import swa.manage.common.PreconditionUtil;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;
import swa.manage.entity.StaffRecord;
import swa.manage.entity.vo.RecordInfoVo;
import swa.manage.entity.vo.SearchVo;
import swa.manage.service.RoomConfigService;
import swa.manage.service.RoomRecordService;
import swa.manage.service.StaffRecordService;
import swa.manage.value.ReserveVo;
import swa.manage.value.TimePeriodEnum;
import swa.manage.value.ValidEnum;

import javax.annotation.Nullable;
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
        List<RoomConfig> roomConfigs = roomConfigService.queryValidConfig(new RoomConfig(searchVo));
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

    @Override
    @Transactional
    public void cancelReserve(Long configId) {
        StaffRecord staffRecord = staffRecordService.queryByPriKey(configId);
        staffRecord.setValidStatus(ValidEnum.INVALID);
        staffRecordService.updateById(staffRecord);
        String timeStr = staffRecord.getReserveTime();
        List<String> times = Splitter.on(",").omitEmptyStrings().splitToList(timeStr);
        List<TimePeriodEnum> timePeriods = Lists.newArrayList(Collections2.transform(times, new Function<String, TimePeriodEnum>() {
            @Nullable
            @Override
            public TimePeriodEnum apply(@Nullable String s) {
                return TimePeriodEnum.toEnum(Integer.valueOf(s));
            }
        }));
        roomRecordService.updatevalidStatus(ValidEnum.VALID, timePeriods, staffRecord.getDate(), staffRecord.getConfigId());

    }


    /**
     * 校验当前是否可以
     *
     * @param reserveVo
     * @return
     */
    @Override
    public void checkReserve(ReserveVo reserveVo) {
        PreconditionUtil.checkArgument(reserveVo != null &&
                !Strings.isNullOrEmpty(reserveVo.getTimePeriodStr()) &&
                null != reserveVo.getConfigId(), "param invalid");
        PreconditionUtil.checkArgument(!Splitter.on(",").omitEmptyStrings().splitToList(reserveVo.getTimePeriodStr()).isEmpty(), "time invalid");
        PreconditionUtil.checkArgument(null != reserveVo.getReserveDate(), "date invalid");
        String userName = CommonServiceUtil.getLoginUserName();
        if (Strings.isNullOrEmpty(userName)) {
            throw new ManageException("请登录后预定");
        }
        reserveVo.setUserName(userName);
        if (!CollectionUtils.isEmpty(roomRecordService.queryRoomRecord(ValidEnum.INVALID, reserveVo.getTimePeriods(), reserveVo.getReserveDate(), reserveVo.getConfigId()))) {
            throw new ManageException("所预定房间不可用,请刷新页面后重试");
        }
    }

    @Override
    public void checkCancelReserve(Long id) {
        StaffRecord record = staffRecordService.queryByPriKey(id);
        if (!record.getUserName().equals(CommonServiceUtil.getLoginUserName())) {
            throw new ManageException("仅限本人操作");

        }
    }


}
