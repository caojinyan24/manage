package swa.manage.value;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 时间枚举
 * Created by jinyan on 7/14/17.
 */
public enum TimePeriodEnum {
    NINE(18, "9:00", "9:30"),
    NINE_HALF(19, "9:30", "10:00"),
    TEN(20, "10:00", "10:30"),
    TEN_HALF(21, "10:30", "11:00"),
    ELEVEN(22, "11:00", "11:30"),
    ELEVEN_HALF(23, "11:30", "12:00"),
    THIRTWEEN(26, "13:00", "13:30"),
    THIRTWEEN_HALF(27, "13:30", "14:00"),
    FOURTEEN(28, "14:00", "14:30"),
    FOURTEEN_HALF(29, "14:30", "15:00"),
    FIFTWEEN(30, "15:00", "15:30"),
    FIFTWEEN_HALF(31, "15:30", "16:00"),
    SIXTWEEN(32, "16:00", "16:30"),
    SIXTWEEN_HALF(33, "16:30", "17:00"),
    SEVENTWEEN(34, "17:00", "17:00"),
    SEVENTWEEN_HALF(35, "17:30", "18:00"),
    EIGHTWEEN(36, "18:00", "18:30"),
    EIGHTWEEN_HALF(37, "18:30", "19:00");


    private static final Map<Integer, String> keyvalueMap = Maps.newLinkedHashMap();
    private static final Map<Integer, TimePeriodEnum> keyEnumMap = Maps.newLinkedHashMap();

    static {
        for (TimePeriodEnum item : TimePeriodEnum.values()) {
            keyvalueMap.put(item.getCode(), item.getStart());
            keyEnumMap.put(item.getCode(), item);
        }
    }

    private final Integer code;
    private final String start;
    private final String end;


    TimePeriodEnum(Integer code, String start, String end) {
        this.code = code;
        this.start = start;
        this.end = end;
    }

    public static Map<Integer, String> getAsMap() {
        return keyvalueMap;
    }

    public static TimePeriodEnum toEnum(Integer code) {
        return keyEnumMap.get(code);
    }

    public Integer getCode() {
        return code;
    }


    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "TimePeriodEnum{" +
                "code=" + code +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
