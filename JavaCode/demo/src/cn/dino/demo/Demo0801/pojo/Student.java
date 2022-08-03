package cn.dino.demo.Demo0801.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    // 避免序列化时出现问题，添加一个serialVersionUID = 42L
    private static final long serialVersionUID = 42L;
    private int age;
    /*
    * 添加transient关键字，使被修饰的成员变量不被序列化
    * 一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法被访问。
    * 此时，若反序列化，得到为该成员变量的默认值（即所对应的数据类型的默认值）
    * */
    // private transient int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
