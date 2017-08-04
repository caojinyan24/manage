package swa.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swa.manage.mapper.StaffVerifyMapper;
import swa.manage.service.StaffVerifyService;

import javax.annotation.Resource;

/**
 * Created by jinyan on 8/3/17 2:28 PM.
 */
@Service
public class StaffVerifyServiceImpl implements StaffVerifyService {
    private static final Logger logger = LoggerFactory.getLogger(StaffVerifyServiceImpl.class);
    @Resource
    private StaffVerifyMapper staffVerifyMapper;

    @Override
    public boolean isValidUser(String userName, String password) {
        return null != staffVerifyMapper.queryUser(userName, password);
    }
}
