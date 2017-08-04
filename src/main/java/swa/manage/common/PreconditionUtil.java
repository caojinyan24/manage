package swa.manage.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinyan on 7/31/17 6:01 PM.
 */
public class PreconditionUtil {
    private static final Logger logger = LoggerFactory.getLogger(PreconditionUtil.class);

    public static void checkArgument(Boolean args, String msg) {
        if (!args) {
            throw new ManageException(msg);
        }
    }

}
