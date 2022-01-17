package cn.hhu.xy.Dao.User;

import cn.hhu.xy.Bean.Stu;
import cn.hhu.xy.Bean.Tch;
import cn.hhu.xy.Bean.User;

import java.util.List;

/**
 * @author cn.hhu.xy
 * @date 2021/7/30
 * @description
 * */
public interface UserDao {

    public List<User> getUserList();

    public List<Stu> getStuList();

    public Tch getTchByID(int tchID);

    public Tch getTchDtlByID(int tchID);

}
