package dtdl;

import net.sf.cglib.proxy.Enhancer;

public class CgDtdl {
    public static void main(String[] args) {
       // UserServiceImpl service = new UserServiceImpl();

        UserServiceCGlib serviceCGlib = new UserServiceCGlib();
        //1. 创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(UserServiceImpl.class);
        //3. 设置回调函数
        enhancer.setCallback(serviceCGlib);
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.addUser();
        System.out.println("11111111");
        userService.deleteUser();
    }
}
