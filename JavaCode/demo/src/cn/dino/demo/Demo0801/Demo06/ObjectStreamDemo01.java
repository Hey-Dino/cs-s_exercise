package cn.dino.demo.Demo0801.Demo06;

import cn.dino.demo.Demo0801.pojo.Student;

import java.io.*;

public class ObjectStreamDemo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("MyFile\\ObjectStream");
        file.mkdirs();

        /*
        * 序列化
        * */
        // 1、创建序列化流对象 ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyFile\\ObjectStream\\oos.txt"));

        // 2、创建 Student 对象(所对应的类需实现 Serializable 接口)，并写入oos
        Student stu1 = new Student(22, "Dino");
        oos.writeObject(stu1);

        // 3、释放资源
        oos.close();

        /*
        * 反序列化
        * */
        // 4、创建反序列化对象 ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyFile\\ObjectStream\\oos.txt"));

        // 5、读取对象
        Object obj = ois.readObject();
        Student stu2 = (Student) obj;
        System.out.println(stu2.getAge() + " " + stu2.getName());

        // 6、释放资源
        ois.close();
    }
}
