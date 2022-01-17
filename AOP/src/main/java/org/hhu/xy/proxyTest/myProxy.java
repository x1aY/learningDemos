package org.hhu.xy.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class myProxy implements InvocationHandler {

    private Object target;

    public void setTarget(Object target){
        this.target=target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        print("invoke method:");
        return method.invoke(target,args);
    }

    public void print(Object obj){
        System.out.println(obj);
    }

}
