package cn.hhu.xy.Bean;


import lombok.Data;

/**
 * @author cn.hhu.xy
 * @date 2021/8/2
 * @description student bean
 * */
@Data
public class Stu {
    private int stuID;
    private String stuName;
    private Tch tch;
}
