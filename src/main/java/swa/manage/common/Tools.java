package swa.manage.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jinyan on 7/17/17 5:55 PM.
 */
public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String str) {
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            logger.error("parseDate error:", e);
            return null;
        }
    }

}
