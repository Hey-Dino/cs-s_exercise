package cn.dino.demo.Demo0725.Case01;

public class Person {
    private String name;
    private int age;
    private static String school;

    public Person() {
        this("空", 0);   // 必须在[首行]调用重载的构造方法
        System.out.println("这是父类的无参构造方法");
    }

    public static String getSchool() {
        return school;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void setSchool(String school) {
        Person.school = school;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
