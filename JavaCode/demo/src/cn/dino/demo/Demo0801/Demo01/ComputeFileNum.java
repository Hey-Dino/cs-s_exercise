package cn.dino.demo.Demo0801.Demo01;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ComputeFileNum {
    public static void main(String[] args) {
        File file = new File("MyFile\\fileModule");
        HashMap<String, Integer> hm = new HashMap<>();
        // 调用函数，统计各类型文件个数
        getCount(file, hm);

        // 遍历HashMap，获取文件统计情况
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            int val = hm.get(key);
            System.out.println(key + "->" + val);
        }
    }

    public static void getCount(File file, HashMap<String, Integer> hm) {
        // 获得file路径名下的所有文件、文件夹
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                // 获取文件全名
                String fileName = f.getName();
                // 分离文件名和后缀名
                String[] fileNameArr = fileName.split("\\.");

                if (fileNameArr.length == 2) {
                    // 获取后缀名
                    String fileEndName = fileNameArr[1];

                    // 判断该后缀名是否已经记录于HashMap中
                    if (hm.containsKey(fileEndName)) {
                        int count = hm.get(fileEndName);
                        // 在原先后缀名出现次数统计的基础上加1
                        hm.put(fileEndName, count + 1);
                    } else {
                        hm.put(fileEndName, 1);
                    }
                }
            } else {
                // 递归处理文件夹，计算该文件夹下的文件、文件夹
                getCount(f, hm);
            }
        }
    }
}
