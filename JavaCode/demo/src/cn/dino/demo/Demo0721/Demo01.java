package cn.dino.demo.Demo0721;

import cn.dino.demo.pojo.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /*
        * Scanner 中 next 和 nextLine 的区别
        * */
        /*System.out.println("Please input:");
        // 遇到了空格, 就不再录入数据了 , 结束标记: 空格, tab键
        // String result = sc.next();
        // 可以将数据完整的接收过来 , 结束标记: 回车换行符
        String result = sc.nextLine();
        System.out.println("Result:" + result);*/

        /*
        * String 的构造及其他方法
        * */
        /*char[] arr = {'H', 'e', 'l', 'l', 'o'};
        System.out.println(new String(arr));
        // 通过new方法创建的相同字符串，指向不同的内存空间
        String s1 = new String("abc");
        String s2 = new String("abc");
        // 通过直接赋值创建的相同字符串，其指向相同的内存空间
        String s3 = "abc";
        String s4 = "abc";
        System.out.println((s1 == s2) + " " + (s3 == s4));
        System.out.println(s1.equals(s2));*/

        /*String str = "Hello, Java!";
        // 遍历方式一
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
        // 遍历方式二
        char[] arr1 = str.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }*/
        // System.out.println(phoneShield("15363386964"));
        // System.out.println(sensitiveReplace("你TMD"));

        /*
        * StringBuilder 的使用
        * */
        /*StringBuilder sb = new StringBuilder("Hello");  // 此处StringBuilder的参数为String，即表示将String转化为StringBuiilder
        sb.append(", StringBuilder.");
        System.out.println("正常语序：" + sb);
        // System.out.println("反转语序：" + sb.reverse());
        String sbToString = sb.toString();  // StringBuilder 转化为 String
        System.out.println("sbToString is String: " + (sbToString instanceof String));*/

        // addVsAppend(10000);

        /*
        * ArrayList 的使用
        * */
        /*ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("IDEA");
        System.out.println(list);
        System.out.println("size:" + list.size());
        System.out.println("get:" + list.get(0));
        System.out.println("set:" + list.set(0, "Javascript"));
        System.out.println("remove:" + list.remove("Java"));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }*/
        ArrayList<Student> students = adminStudents();
        System.out.println(students);
    }

    // 手机号屏蔽
    public static String phoneShield(String number) {
        String start = number.substring(0, 3);
        String end = number.substring(7);

        return start + "****" + end;
    }

    // 敏感词替换
    public static String sensitiveReplace(String str) {
        return str.replace("TMD", "***");
    }

    // 区分 String 和 StringBuilder 不同拼接方式之间的效率差别
    public static void addVsAppend(int num){
        long startTime = 0, endTime = 0;

        startTime = System.currentTimeMillis();
        String str = new String();
        for (int i = 0; i < num; i++) {
            str += i + " ";
        }
        System.out.println("Add方式所用时间: " + ((System.currentTimeMillis() - startTime)) + "ms");

        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(i + " ");
        }
        System.out.println("Append方式所用时间: " + ((System.currentTimeMillis() - startTime)) + "ms");
    }

    public static ArrayList<Student> adminStudents() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Please input the number of student:");
        int studentsNum = sc.nextInt();

        for (int i = 0; i < studentsNum; i++) {
            Student student = new Student();

            System.out.println("Please input the information of the No." + (i + 1) + " student.");
            System.out.print("ID: ");
            student.setSid(sc.next());
            System.out.print("Name: ");
            student.setSname(sc.next());
            System.out.print("Age: ");
            student.setAge(sc.nextInt());
            System.out.print("Birthday: ");
            student.setBirthday(sc.next());
            System.out.println();

            students.add(student);
        }

        return students;
    }
}
