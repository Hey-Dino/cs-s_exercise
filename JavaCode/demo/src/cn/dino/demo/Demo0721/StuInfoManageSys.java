package cn.dino.demo.Demo0721;

import cn.dino.demo.pojo.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StuInfoManageSys {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-----Student Information Management System-----");
            System.out.println("1.Add Student");
            System.out.println("2.Delete Student");
            System.out.println("3.Update Student");
            System.out.println("4.Show Student");
            System.out.println("5.Exit System");
            System.out.println("Please input your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStu();
                    break;
                case 2:
                    delStu();
                    break;
                case 3:
                    updateStu();
                    break;
                case 4:
                    showStu();
                    break;
                case 5:
                    System.out.println("Welcome to use again!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is error!");
            }

            System.out.println();
        }
    }

    public static String addStu() {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();

        System.out.println("Please input the information of the student.");
        // 避免ID号重复
        while (true) {
            System.out.print("ID: ");
            String sid = sc.next();
            if (getIndex(sid) != -1) {
                System.out.println("Student's ID already exists!");
            } else {
                stu.setSid(sid);
                break;
            }
        }
        System.out.print("Name: ");
        String sname = sc.next();
        stu.setSname(sname);
        System.out.print("Age: ");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.print("Birthday: ");
        String birthday = sc.next();
        stu.setBirthday(birthday);

        // 将学生插入到集合中
        students.add(stu);

        return stu.toString();
    }

    public static void delStu() {
        if (students.size() == 0) {
            System.out.println("The information of students is empty!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the ID of the student: ");
        while (true) {
            String sid = sc.next();
            int index = getIndex(sid);
            if (index == -1) {
                System.out.println("Student does not exist!");
            } else {
                students.get(index).setStatus(1);
                System.out.println("Delete the student successfully!");
                break;
            }
        }
    }

    public static void updateStu() {
        if (students.size() == 0) {
            System.out.println("The information of students is empty!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the information below.");
        while (true) {
            System.out.print("ID: ");
            String sid = sc.next();
            int index = getIndex(sid);

            if (index == -1) {
                System.out.println("Student does not exist!");
            } else {
                Student stu = students.get(index);

                System.out.print("Name(" + stu.getSname() + "): ");
                String sname = sc.next();
                System.out.print("Age(" + stu.getAge() + "): ");
                int age = sc.nextInt();
                System.out.print("Birthday(" + stu.getBirthday() + "): ");
                String birthday = sc.next();

                stu = new Student(sid, sname, age, birthday);
                students.set(index, stu);
                System.out.println("Update the student successfully!");

                break;
            }
        }
    }

    public static void showStu() {
        if (students.size() == 0) {
            System.out.println("The information of students is empty!");
            return;
        }

        System.out.println("ID    Name    Age    Birthday");
        for (Student stu : students) {
            if (stu.getStatus() == 0) {
                System.out.println(stu.getSid() + "   " + stu.getSname() + "   " + stu.getAge() + "   " + stu.getBirthday());
            }
        }
    }

    // 查询对应ID的学生是否存在
    public static int getIndex(String sid) {
        int index = -1;

        for (int i = 0; i < students.size(); i++) {
            if (sid.equals(students.get(i).getSid())) {
                index = i;
                break;
            }
        }

        return index;
    }
}
