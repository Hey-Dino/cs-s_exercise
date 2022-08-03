package cn.dino.demo.Demo0801.Demo04;

import java.io.*;

public class BufferedStreamDemo02 {
    /*
    * newLine() 和 readLine() 的使用
    * */
    public static void main(String[] args) throws IOException {
        // 写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("MyFile\\BufferedStream\\bw.txt"));
        bw.write("Hello, World");
        bw.newLine();
        bw.write("Hello, Java");
        bw.newLine();
        bw.write("Hello, Buffered Stream");
        bw.close();

        // 读取数据
        BufferedReader br = new BufferedReader(new FileReader("MyFile\\BufferedStream\\bw.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
