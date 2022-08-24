package com.dino;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MessyCodeShow {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "迪诺";
        System.out.println("原数据：" + name);
        // 1.使用UTF-8编码结果
        String encode = URLEncoder.encode(name, "UTF-8");
        System.out.println("UTF-8编码结果：" + encode);
        // 2.使用ISO-8859-1解码结果
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println("ISO-8859-1解码：" + decode);
        // 3.解决乱码
        //  3.1 先对乱码数据进行编码，随后转化为字节数组
        byte[] bytes = decode.getBytes(StandardCharsets.ISO_8859_1);
        //  3.2 对字节数组进行解码
        // String solved = new String(bytes, StandardCharsets.UTF_8);   // 写法一
        String solved = new String(bytes, "UTF-8");     // 写法二
        System.out.println("解决后：" + solved);
    }
}
