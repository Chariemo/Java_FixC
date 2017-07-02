package cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Charley on 2017/6/4.
 */
public class CglibProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clasz) {

        enhancer.setSuperclass(clasz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        PerformanceMonitor.end();
        return result;
    }
}
