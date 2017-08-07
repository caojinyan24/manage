package swa.manage.common;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swa.manage.value.TimePeriodEnum;

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
        List<String> newList = Lists.newArrayList();
        if (timeStrs.size() == 1) {
            newList = timeStrs;
        } else {
            for (int i = 0; i < timeStrs.size() - 1; i++) {
                newList.add(timeStrs.get(i));
                if (timeStrs.get(i + 1).compareTo(timeStrs.get(i)) > 1) {
                    newList.add(",");
                }
            }
            newList.add(timeStrs.get(timeStrs.size() - 1));
        }

        List<List<Integer>> lists = Lists.newArrayList();

        List<Integer> temp = Lists.newArrayList();
        if (newList.contains(",")) {
            for (String s : newList) {
                if (",".equals(s)) {
                    lists.add(temp);
                    temp.clear();
                } else {
                    temp.add(Integer.valueOf(s));
                }
            }
            lists.add(temp);
        } else {
            for (String s : newList) {
                temp.add(Integer.valueOf(s));
            }
            lists.add(temp);
        }


        StringBuilder sb = new StringBuilder("");
        for (List<Integer> list : lists) {
            sb.append(TimePeriodEnum.toEnum(list.get(0)).getStart()).append('-').append(TimePeriodEnum.toEnum(list.get(list.size() - 1)).getEnd()).append("&&");
        }
        String result = sb.toString();
        return result.substring(0, result.lastIndexOf("&&"));
    }

    public static void main(String[] args) {
        System.out.println(getShowTime("31,33,34"));
    }
}
