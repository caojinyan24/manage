package swa.manage.common;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swa.manage.value.TimePeriodEnum;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by jinyan on 7/24/17 6:25 PM.
 */
public class CommonServiceUtil {
    private static final Logger logger = LoggerFactory.getLogger(CommonServiceUtil.class);

    public static String getShowTime(String str) {
        List<String> timeStrs = Splitter.on(",").omitEmptyStrings().splitToList(str);
        if (timeStrs.isEmpty()) {
            throw new ManageException("时间字符串解析失败");
        }
        List<Integer> times = Lists.newArrayList(Collections2.transform(timeStrs, new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String s) {
                return Integer.valueOf(s);
            }
        }));
        StringBuilder sb = new StringBuilder("");
        if (times.size() == 1) {
            TimePeriodEnum timePeriodEnum = TimePeriodEnum.toEnum(times.get(0));
            sb.append(timePeriodEnum.getStart()).append('-').append(timePeriodEnum.getEnd());
            return sb.toString();

        } else {
            Integer flag = 0;
            for (int i = 0; i < times.size() - 1; i++) {
                if (times.get(i + 1) - times.get(i) > 1) {
                    if (!Strings.isNullOrEmpty(sb.toString())) {
                        sb.append("&&");
                    }
                    sb.append(TimePeriodEnum.toEnum(times.get(flag)).getStart());
                    sb.append('-').append(TimePeriodEnum.toEnum(times.get(i)).getEnd());
                    flag = i + 1;
                }
            }
            if (flag == times.size() - 1) {
                TimePeriodEnum timePeriodEnum = TimePeriodEnum.toEnum(times.get(flag));
                sb.append("&&").append(timePeriodEnum.getStart()).append('-').append(timePeriodEnum.getEnd());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(getShowTime("18,,26,27,30"));
    }
}
