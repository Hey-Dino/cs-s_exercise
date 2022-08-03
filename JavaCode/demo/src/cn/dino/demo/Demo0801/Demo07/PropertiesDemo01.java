package cn.dino.demo.Demo0801.Demo07;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo01 {
    /*
    * Properties 是Map体系中的一个集合类
    * 不同于 HashMap 和 TreeMap，其创建时不使用 new PropertiesM<T, T>()的定义方式
    * 而是直接使用new Properties() 方式
    * */
    public static void main(String[] args) {
        //
        Properties prop = new Properties();

        prop.put("001", "Dino");
        prop.put("002", "Pedro");
        prop.put("001", "Peppa");   // 键相同时，后者会覆盖前者

        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object val = prop.get(key);
            System.out.println(key + " " +val);
        }
    }
}
