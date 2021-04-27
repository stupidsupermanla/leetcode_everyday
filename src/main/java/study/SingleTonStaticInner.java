package study;

/**
 * @Description
 * @Author hudi
 * @Date 2021/4/28
 * @Version 1.0
 **/
public class SingleTonStaticInner {

    private SingleTonStaticInner() {
        if (SingleTonStaticInnerClass.singleTonStaticInner!=null){
            throw new RuntimeException("单例构造器不能反射调用");
        }
    }

    public static SingleTonStaticInner getInstance() {
        return SingleTonStaticInnerClass.singleTonStaticInner;
    }

    private static class SingleTonStaticInnerClass {
        public static final  SingleTonStaticInner singleTonStaticInner = new SingleTonStaticInner();
    }
}
