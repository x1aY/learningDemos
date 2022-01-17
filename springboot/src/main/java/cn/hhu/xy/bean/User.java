package cn.hhu.xy.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cn.hhu.xy
 * @date 2021/8/7
 * @description 用户bean
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int uID;
    private String uName;
    private String uPwd;
    private UserType uType;

}
