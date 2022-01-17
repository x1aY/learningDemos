package org.hhu.xy;

import org.hhu.xy.service.Stu;
import org.hhu.xy.service.User;
import org.hhu.xy.service.UserServ;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AOPTest {

    @Test
    public void testAop(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userBean=ac.getBean("user");
        Stu userStu=(Stu) userBean;
        UserServ userServ=(UserServ) userBean;
        userStu.stuLoc();
        userServ.add();
    }
}
