package cn.dino.demo.Demo0728.Demo03;

/*
* 泛型类
* */
public class GenericImpl<T> implements GenericIner<T> {
    @Override
    public void show(T t) {
        System.out.println("展示泛型值01：" + t);
    }

    /*
     * 泛型方法
     * */
    public <T> void show02(T t) {
        System.out.println("展示泛型值02：" + t);
    }
}
