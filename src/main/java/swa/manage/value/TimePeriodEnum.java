package swa.manage.value;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 时间枚举
 * Created by jinyan on 7/14/17.
 */
public enum TimePeriodEnum {
    NINE(18, "9:00"),
    NINE_HALF(19, "9:30"),
    TEN(20, "10:00"),
    TEN_HALF(21, "10:30"),
    ELEVEN(22, "11:00"),
    ELEVEN_HALF(23, "11:30"),
    THIRTWEEN(26, "13:00"),
    THIRTWEEN_HALF(27, "13:30"),
    FOURTEEN(28, "14:00"),
    FOURTEEN_HALF(29, "14:30"),
    FIFTWEEN(30, "15:00"),
    FIFTWEEN_HALF(31, "15:30"),
    SIXTWEEN(32, "16:00"),
    SIXTWEEN_HALF(33, "16:30"),
    SEVENTWEEN(34, "17:00"),
    SEVENTWEEN_HALF(35, "17:30"),
    EIGHTWEEN(36, "18:00"),
    EIGHTWEEN_HALF(37, "18:30");


    private static final Map<Integer, String> keyvalueMap = Maps.newLinkedHashMap();
    private static final Map<Integer, TimePeriodEnum> keyEnumMap = Maps.newLinkedHashMap();

    static {
        for (TimePeriodEnum item : TimePeriodEnum.values()) {
            keyvalueMap.put(item.getCode(), item.getDesc());
            keyEnumMap.put(item.getCode(), item);
        }
    }

    private final Integer code;
    private final String desc;

    TimePeriodEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
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


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "TimePeriodEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
