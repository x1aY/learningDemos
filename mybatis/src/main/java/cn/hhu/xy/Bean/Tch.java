package cn.hhu.xy.Bean;


import lombok.Data;

import java.util.List;

/**
 * @author cn.hhu.xy
 * @date 2021/8/2
 * @description teacher bean
 * */
@Data
public class Tch {
    private int tchID;
    private String tchName;
    private List<Stu> students;
}
