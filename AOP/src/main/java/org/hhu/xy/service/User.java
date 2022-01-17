package org.hhu.xy.service;

import org.springframework.stereotype.Service;

@Service
public class User implements UserServ, Stu {


    @Override
    public void add() {
        System.out.println("add method");
    }

    @Override
    public void del() {
        System.out.println("delete method");
    }

    @Override
    public void stuName() {
        System.out.println("stu name");
    }

    @Override
    public void stuLoc() {
        System.out.println("stu location");
    }
}
