package cn.dino.demo.Demo0725.Case01;

public class Teacher extends Person{
    public Teacher() {
    }

    // 利用父类的有参构造方法
    public Teacher(String name, int age) {
        super(name, age);
    }

    public void teach(){
        System.out.println("教书！");
    }
}
