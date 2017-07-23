package swa.manage.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import swa.manage.entity.RoomConfig;

import javax.annotation.Resource;


/**
 * Created by jinyan on 7/3/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomConfigMapperTest {
    @Resource
    private RoomConfigMapper roomConfigMapper;

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDeleteByPriKey() throws Exception {

    }

    @Test
    public void testQueryConfig() throws Exception {
        RoomConfig roomConfig = new RoomConfig();
        roomConfig.setId(15L);
        System.out.println(roomConfigMapper.queryConfig(roomConfig));
    }
}