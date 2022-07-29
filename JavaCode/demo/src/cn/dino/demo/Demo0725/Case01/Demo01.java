package cn.dino.demo.Demo0725.Case01;

public class Demo01 {
    public static void main(String[] args) {
        // 查看子类的【无参构造方法】是否会默认先调用父类的【无参构造方法】
        Student stu = new Student();    // 结果：会
        Teacher teacher = new Teacher();

        // 设置父类的static属性（通过类名、对象名）
        Person.setSchool("HSTC");   // 通过类名修改static属性
        stu.setSchool("韩山师范学院");    // 通过对象名修改static属性
        // 查看子类所继承的该属性是否都被修改
        System.out.println(stu);
        System.out.println(teacher);
        System.out.println(Person.getSchool());

        // 查看子类的【有参构造方法】是否会默认先调用父类的【无参构造方法】
        Student stu2 = new Student(01);     // 结果：会
    }
}
