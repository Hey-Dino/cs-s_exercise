package cn.dino.demo.Demo0801.Demo04;

import java.io.*;

public class BufferedStreamDemo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("MyFile\\BufferedStream");
        file.mkdirs();

        // 写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("MyFile\\BufferedStream\\bw.txt"));
        bw.write("Hello\r\n");
        bw.write("World\r\n");
        bw.close();

        // 读取数据
        BufferedReader br = new BufferedReader(new FileReader("MyFile\\BufferedStream\\bw.txt"));
        int ch;
        while ((ch = br.read()) != -1) {
            System.out.print((char) ch);
        }
        br.close();
    }
}
