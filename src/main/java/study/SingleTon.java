package study;

/**
 * @Description
 * @Author hudi
 * @Date 2021/4/27
 * @Version 1.0
 **/
public class SingleTon implements Cloneable{

    private SingleTon() {
        if (instance!=null){
            throw new RuntimeException("单例构造器不能反射调用");
        }
    }

    @Override
    public SingleTon clone() {
        return instance;
    }

    private static volatile SingleTon instance;

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }

}
