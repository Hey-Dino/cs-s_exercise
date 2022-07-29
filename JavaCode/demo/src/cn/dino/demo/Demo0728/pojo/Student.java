package cn.dino.demo.Demo0728.pojo;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int age;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

    @Override
    public int compareTo(Student o) {
        // return 0;   // 表示只存入一个数据
        // return 1;   // 表示按add()顺序存入
        // return -1;  // 表示按add()的逆序存入

        // 下面为按实际内容进行比较，通过调整 this 和 o 对象的先后顺序实现升序、降序
        int num = this.name.compareTo(o.name);   // 主规格——按名字字母升序
        // int num = o.name.compareTo(this.name);   // 主规格——按名字字母降序
        int num2 = num == 0 ? this.age - o.age : num;   // 次要规格——按年龄升序

        return num2;
    }
}
