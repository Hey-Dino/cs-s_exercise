package cn.dino.demo.Demo0801.Demo03;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\BufferedStream");
        file.mkdir();

        // 1、创建 BufferedOutputStream 对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("MyFile\\BufferedStream\\bos.txt"));
        // 2、写入数据
        bos.write("Hello, World!\r\n".getBytes());
        bos.write("Hello, BufferedStream!\r\n".getBytes());
        // 3、释放资源
        bos.close();

        // 4、创建 BufferedIntputStream 对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("MyFile\\BufferedStream\\bos.txt"));
        // 5、读取数据
        byte[] bys = new byte[1024];    // 单次读取支持的数据大小
        int len;    // 存储偏移量
        while ((len = bis.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        // 6、释放资源
        bis.close();
    }
}
