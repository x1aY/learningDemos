package org.hhu.xy.proxyTest;

import org.hhu.xy.service.UserServ;
import org.hhu.xy.service.User;

import java.util.Arrays;

public class client {
    public static void main(String[] args) {
        User userI =new User();
        myProxy myPiH=new myProxy();
        myPiH.setTarget(userI);
        UserServ myP=(UserServ) myPiH.getProxy();
        System.out.println(Arrays.toString(myP.getClass().getInterfaces()));
    }
}
