package dtdl;

import java.lang.reflect.Proxy;

public class JdkDtdl {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService p = (HelloService) Proxy.newProxyInstance(HelloServiceImpl.class.getClassLoader(),
                new Class[]{HelloService.class}, new HelloServiceHandler(helloService));
        p.sayHello();
    }
}
