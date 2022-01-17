package cn.hhu.xy.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xy
 * @date 2021/8/23
 * @description 
 * */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run myThread");
    }
}
