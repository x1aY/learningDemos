package cn.hhu.xy.Bean;


import lombok.*;

/**
 * @author cn.hhu.xy
 * @date 2021/7/30
 * @description 用户bean
 * */
@Data
public class User {

    private int uID;
    private String uName;
    private String uPwd;
    private UserType uType;

}
