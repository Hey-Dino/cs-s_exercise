package cn.dino.demo.Demo0725.Case01;

public class Student extends Person {
    private int sid;

    // 无参构造方法
    public Student() {
        super();    // 系统默认会在首行调用父类的无参构造方法，因而此处的super()可以省略
        System.out.println("这是【子类】的[无参]构造方法！");
    }

    public Student(int sid) {
        // super();    // 系统默认会在首行调用父类的无参构造方法，因而此处的super()可以省略
        System.out.println("这是【子类】的[有参]构造方法！");
        this.sid = sid;
    }

    public void study(){
        System.out.println("学习！");
    }
}
