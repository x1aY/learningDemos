package cn.hhu.xy.Bean;

/**
 * @author cn.hhu.xy
 * @date 2021/7/30
 * @description 用户类型枚举类
 * */
public enum UserType{
    /**
     * 最高权限
     * */
    superAdmin("超级管理员"),
    /**
     * 次级权限
     * */
    admin("后台管理人员"),
    /**
     * 普通权限
     * */
    user("用户");

    private final String cmn;

    private UserType(String cmn) {
        this.cmn = cmn;
    }

    public String getCmn() {
        return this.cmn;
    }
}
