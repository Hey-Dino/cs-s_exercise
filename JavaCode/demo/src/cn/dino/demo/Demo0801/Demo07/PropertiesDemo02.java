package cn.dino.demo.Demo0801.Demo07;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo02 {
    /*
    * Properties 作为Map集合的特有方法
    * */
    public static void main(String[] args) {
        // 1、创建集合对象
        Properties prop = new Properties();

        // 2、设置集合的键和值，其都为String类型
        prop.setProperty("001", "Dino");
        prop.setProperty("002", "Pedro");
        prop.setProperty("003", "Peppa");

        // 3、从属性列表中返回一个不可修改的键集，其中键及其对应的值为字符串
        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            String val = prop.getProperty(key);
            System.out.println(key + " " + val);
        }
    }
}
