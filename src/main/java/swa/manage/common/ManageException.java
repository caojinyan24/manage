package swa.manage.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinyan on 7/24/17 6:33 PM.
 */
public class ManageException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ManageException.class);

    public ManageException(String message) {
        super(message);
    }

}
