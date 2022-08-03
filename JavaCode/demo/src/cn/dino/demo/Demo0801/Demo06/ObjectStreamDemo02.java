package cn.dino.demo.Demo0801.Demo06;

import cn.dino.demo.Demo0801.pojo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamDemo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        * 序列化
        * */
        // 1、创建序列化流对象 oos
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyFile\\ObjectStream\\oos.txt"));

        List<Student> stuList1 = new ArrayList<>();
        stuList1.add(new Student(22, "Dino"));
        stuList1.add(new Student(12, "Pedro"));

        // 2、将学生对象集合写入到序列化对象中
        oos.writeObject(stuList1);

        // 3、释放资源
        oos.close();


        /*
        * 反序列化
        * */
        // 4、创建反序列化流对象 ois
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyFile\\ObjectStream\\oos.txt"));

        Object obj = ois.readObject();
        List<Student> stuList2 = (List<Student>) obj;
        for (Student stu : stuList2) {
            System.out.println(stu.getAge() + " " + stu.getName());
        }
    }
}
