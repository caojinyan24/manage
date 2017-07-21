package swa.manage.value;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by jinyan on 7/17/17 4:00 PM.
 */
public enum ValidEnum {
    VALID(1, "可用"),
    INVALID(0, "不可用");
    private static final Map<Integer, String> map = Maps.newHashMap();
    private static final Map<Integer, ValidEnum> keyEnumMap = Maps.newHashMap();

    static {
        for (ValidEnum t : ValidEnum.values()) {
            map.put(t.code, t.msg);
            keyEnumMap.put(t.code, t);
        }
    }

    private final Integer code;
    private final String msg;
    ValidEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ValidEnum toEnum(Integer code) {
        return keyEnumMap.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ValidEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
