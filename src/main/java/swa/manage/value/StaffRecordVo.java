package swa.manage.value;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swa.manage.common.CacheInfoUtil;
import swa.manage.common.CommonServiceUtil;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.StaffRecord;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by jinyan on 7/24/17 7:58 PM.
 */
public class StaffRecordVo {
    private static final Logger logger = LoggerFactory.getLogger(StaffRecordVo.class);
    StaffRecord staffRecord;
    String timeShow;
    String roomName;

    public StaffRecordVo() {
    }

    public StaffRecordVo(StaffRecord staffRecord, String timeShow, String roomName) {
        this.staffRecord = staffRecord;
        this.timeShow = timeShow;
        this.roomName = roomName;
    }

    public static List<StaffRecordVo> convert(List<StaffRecord> records) {
        return Lists.newArrayList(Collections2.transform(records, new Function<StaffRecord, StaffRecordVo>() {
            @Nullable
            @Override
            public StaffRecordVo apply(@Nullable StaffRecord staffRecord) {
                RoomConfig roomConfig = CacheInfoUtil.getRoomConfigMap().get(staffRecord.getConfigId().toString());
                return new StaffRecordVo(staffRecord, CommonServiceUtil.getShowTime(staffRecord.getReserveTime()), roomConfig.getRegion() + ' ' + roomConfig.getLayer() + ' ' + roomConfig.getRoomName());
            }
        }));
    }

    public StaffRecord getStaffRecord() {
        return staffRecord;
    }

    public void setStaffRecord(StaffRecord staffRecord) {
        this.staffRecord = staffRecord;
    }

    public String getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(String timeShow) {
        this.timeShow = timeShow;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "StaffRecordVo{" +
                "staffRecord=" + staffRecord +
                ", timeShow='" + timeShow + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
