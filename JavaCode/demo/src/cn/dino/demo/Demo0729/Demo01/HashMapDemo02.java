package cn.dino.demo.Demo0729.Demo01;

import cn.dino.demo.Demo0729.pojo.Student;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo02 {
    public static void main(String[] args) {
        Student stu1 = new Student("Dino", 22);
        Student stu2 = new Student("Peppa", 18);
        Student stu3 = new Student("Pedro", 3);

        // 键：String 值：Student
        HashMap<String, Student> hashMap01 = new HashMap<>();
        hashMap01.put("001", stu1);
        hashMap01.put("002", stu2);
        hashMap01.put("003", stu3);
        // 遍历
        System.out.println("--键：String 值：Student--");
        Set<String> keySet01 = hashMap01.keySet();
        for (String key : keySet01) {
            Student val = hashMap01.get(key);
            System.out.println(key + "-" + val.getAge() + "," + val.getName());
        }

        // 键：Student 值：String
        HashMap<Student, String> hashMap02 = new HashMap<>();
        hashMap02.put(stu1, "001");
        hashMap02.put(stu2, "002");
        hashMap02.put(stu3, "003");
        // 遍历
        System.out.println("--键：Student 值：String--");
        Set<Student> keySet02 = hashMap02.keySet();
        for (Student key : keySet02) {
            String val = hashMap02.get(key);
            System.out.println(key.getAge() + "," + key.getName() + "-" + val);
        }
    }

    /*public static <T> void ergodicMap(HashMap<T, T> hashMap) {
        Set<T> keySet = hashMap.keySet();
        for (T key : keySet) {
            T val = hashMap.get(key);
            System.out.println(key + "-" + val);
        }
    }*/
}
