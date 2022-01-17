package cn.hhu.xy.dao.user;

import cn.hhu.xy.bean.User;
import cn.hhu.xy.config.database.DSKey;
import cn.hhu.xy.config.database.DsSwitcher;
import cn.hhu.xy.bean.Dept;
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

    @DsSwitcher(DSKey.xcgMysql)
    public List<Dept> getDeptList();
}
