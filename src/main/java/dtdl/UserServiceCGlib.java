package dtdl;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceCGlib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强开始~~~");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("增强结束~~~");
        return result;
    }
}
