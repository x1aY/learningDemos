package cn.hhu.xy;

import cn.hhu.xy.dao.user.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class XyApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    DataSource myDruidDataSource;


    @Test
    void contextLoads() throws SQLException {
        String s = userDao.getUserList().toString();
        log.info(s);
    }
}
