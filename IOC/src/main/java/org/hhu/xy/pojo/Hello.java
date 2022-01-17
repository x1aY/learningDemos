package org.hhu.xy.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author cn.hhu.xy
 */

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hello {

    @Value("cn.hhu.xy")
    private String name;

    private Lab lab;

    @Autowired
    private void setLab(Lab lab){
        this.lab=lab;
    }

    public void setName(String name) {
        this.name = name;
    }
}
