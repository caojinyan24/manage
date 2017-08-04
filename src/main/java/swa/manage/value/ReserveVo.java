package swa.manage.value;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.format.annotation.DateTimeFormat;
import swa.manage.entity.StaffRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by jinyan on 7/17/17 4:45 PM.
 */
public class ReserveVo {
    private static final Splitter splitter = Splitter.on(",").omitEmptyStrings();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date reserveDate;
    Long configId;
    String timePeriodStr;
    String reserveStaffName;
    String reserveStaffPhone;
    String reserveReason;

    public static StaffRecord assembleStaffRecord(ReserveVo reserveVo) {
        StaffRecord staffRecord = new StaffRecord();
        staffRecord.setComment(reserveVo.getReserveReason());
        staffRecord.setDate(reserveVo.getReserveDate());
        staffRecord.setConfigId(reserveVo.getConfigId());
        staffRecord.setStaffName(reserveVo.getReserveStaffName());
        staffRecord.setReserveTime(reserveVo.getTimePeriodStr());
        staffRecord.setValidStatus(ValidEnum.VALID);
        return staffRecord;
    }

    public List<TimePeriodEnum> getTimePeriods() {
        List<TimePeriodEnum> result = Lists.newLinkedList();
        List<String> times = splitter.splitToList(this.timePeriodStr);
        for (String s : times) {
            TimePeriodEnum e = TimePeriodEnum.toEnum(Integer.valueOf(s));
            if (e != null) {
                result.add(e);
            }
        }
        return result;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getTimePeriodStr() {
        return timePeriodStr;
    }

    public void setTimePeriodStr(String timePeriodStr) {
        this.timePeriodStr = timePeriodStr;
    }

    public String getReserveStaffName() {
        return reserveStaffName;
    }

    public void setReserveStaffName(String reserveStaffName) {
        this.reserveStaffName = reserveStaffName;
    }

    public String getReserveStaffPhone() {
        return reserveStaffPhone;
    }

    public void setReserveStaffPhone(String reserveStaffPhone) {
        this.reserveStaffPhone = reserveStaffPhone;
    }

    public String getReserveReason() {
        return reserveReason;
    }

    public void setReserveReason(String reserveReason) {
        this.reserveReason = reserveReason;
    }

    @Override
    public String toString() {
        return "ReserveVo{" +
                "reserveDate=" + reserveDate +
                ", configId=" + configId +
                ", timePeriodStr='" + timePeriodStr + '\'' +
                ", reserveStaffName='" + reserveStaffName + '\'' +
                ", reserveStaffPhone='" + reserveStaffPhone + '\'' +
                ", reserveReason='" + reserveReason + '\'' +
                '}';
    }
}
