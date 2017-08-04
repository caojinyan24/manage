package swa.manage.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import swa.manage.entity.StaffVerify;

/**
 * StaffVerifyMapper
 * Created by jinyan.cao on 2017-08-03 14:15:34
 */
@Repository
public interface StaffVerifyMapper {

    void add(StaffVerify staffVerify);

    void update(StaffVerify staffVerify);

    void deleteByPriKey(Long id);

    StaffVerify queryUser(@Param("userName") String userName, @Param("password") String password);

}