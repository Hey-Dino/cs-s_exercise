package cn.dino.demo.Demo0801.Demo07;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo03 {
    /*
    * Properties 和 IO流相结合的方法
    *   - void load(Reader reader)
    *   - void store(Writer writer, String comments)
    * */
    public static void main(String[] args) throws IOException {
        myStore();
        myLoad();
    }

    /*
    * 用于读取文件数据
    * */
    public static void myLoad() throws IOException {
        // 1、创建 Properties 对象
        Properties prop = new Properties();

        // 2、利用 Properties 对象的 load() 方法读取文件数据
        FileReader fr = new FileReader("MyFile\\Properties\\fw.txt");
        prop.load(fr);

        // 3、循环遍历读取到的数据
        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            String val = prop.getProperty(key);
            System.out.println(key + " " + val);
        }

        // 4、释放FileReader资源
        fr.close();
    }

    /*
    * 用于将Properties数据存储于文件中
    * */
    public static void myStore() throws IOException {
        File file = new File("MyFile\\Properties");
        file.mkdirs();

        // 1、创建集合对象
        Properties prop = new Properties();

        // 2、设置集合的键和值，其都为String类型
        prop.setProperty("001", "Dino");
        prop.setProperty("002", "Pedro");
        prop.setProperty("003", "Peppa");

        // 3、创建FileWriter对象，并把Properties对象存储于其中
        FileWriter fw = new FileWriter("MyFile\\Properties\\fw.txt");
        prop.store(fw, null);

        // 4、释放FileWriter资源
        fw.close();
    }
}
