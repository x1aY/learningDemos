package cn.hhu.xy;

import cn.hhu.xy.dao.user.UserDao;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class DruidTests {

    @Autowired
    UserDao userDao;

    @Resource(name = "myDruidDataSource")
    DruidDataSource myDruidDataSource;

    @Resource(name = "xyMysql")
    DataSource myDynamicDataSource;

    @Resource(name = "xcgMysql")
    DataSource myDynamicDataSourceTwo;


    // TODO 注入成功
    @Test
    void contextLoads() throws SQLException {
        String s = userDao.getUserList().toString();
       s = myDruidDataSource.toString();
       s = myDynamicDataSource.toString();
       s = myDynamicDataSourceTwo.toString();
        s = userDao.getDeptList().toString();
        log.info(s);
    }
}
