package cn.dino.demo.Demo0728.Demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UseDate {
    public static void main(String[] args) throws ParseException {
        System.out.println("-----当前时间（两种表示方式）-----");
        Date date = new Date();
        System.out.println(date);   // Thu Jul 28 10:19:42 CST 2022
        System.out.println(System.currentTimeMillis());    // 1658974782294

        System.out.println("-----为Date设置时间-----");
        date.setTime(1658974782294L);
        System.out.println(date);

        System.out.println("-----日期格式相互转换-----");
        System.out.println(dateToString(date, "yyyy-MM-dd"));
        System.out.println(stringToDate("2022年07月28号", "yyyy年MM月dd号"));

    }

    /*
    * Date类型的日期转化为String类型
    * */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String result = dateFormat.format(date);

        return result;
    }

    /*
    * String类型的日期转化为Date类型
    * */
    public static Date stringToDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date result = dateFormat.parse(dateStr);

        return result;
    }
}
