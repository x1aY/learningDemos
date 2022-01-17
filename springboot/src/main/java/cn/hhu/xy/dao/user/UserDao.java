package cn.hhu.xy.dao.user;

import cn.hhu.xy.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cn.hhu.xy
 * @date 2021/8/7
 * @description
 * */
@Mapper
@Repository
public interface UserDao {

    /**
     *  test
     * @return all users
     */
    public List<User> getUserList();

}
