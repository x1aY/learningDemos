package cn.hhu.xy.thread;

import org.junit.Test;

public class threadTest {

    @Test
    public void myThreadTest(){
        MyThread myThread = new MyThread();
        myThread.start();
    }


}
