package cn.hhu.xy;

import cn.hhu.xy.Dao.User.UserDao;
import cn.hhu.xy.Util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void testMybatis(){
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            UserDao userdao = sqlSession.getMapper(UserDao.class);
            System.out.println(userdao.getTchDtlByID(1));
//            userdao.getStuList().forEach(System.out::println);
        }
    }



}
