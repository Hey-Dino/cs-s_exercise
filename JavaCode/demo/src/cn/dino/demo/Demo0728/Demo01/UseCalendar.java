package cn.dino.demo.Demo0728.Demo01;

import java.util.Calendar;
import java.util.Scanner;

public class UseCalendar {
    public static void main(String[] args) {
        System.out.println("-----获取当前日期-----");
        Calendar instance = Calendar.getInstance();
        System.out.println(getDate(instance));

        System.out.println("-----3年前的今天-----");
        instance.add(Calendar.YEAR, -3);
        System.out.println(getDate(instance));

        System.out.println("-----10年后、10天前-----");
        instance = Calendar.getInstance();      // 重置，避免上面实例的影响
        instance.add(Calendar.YEAR, 10);
        instance.add(Calendar.DATE, -10);
        System.out.println(getDate(instance));

        System.out.println("-----获取某一年的二月天数-----");
        System.out.println("2022年2月天数：" + getFebLen(2022));
    }

    // 根据 Calendar 获取某一格式的 String类型的时间
    public static String getDate(Calendar instance) {
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DATE);

        return (year + "-" + month + "-" + day);
    }

    // 获取输入年份的二月天数
    public static int getFebLen(int year) {
        Calendar instance = Calendar.getInstance();
        // Calendar 的 month 是从0开始算起的，2 即代表三月
        instance.set(year, 2, 1);
        // 三月一号 的天数减1，即表示二月份的最后一天
        instance.add(Calendar.DATE, -1);

        return instance.get(Calendar.DATE);
    }
}
