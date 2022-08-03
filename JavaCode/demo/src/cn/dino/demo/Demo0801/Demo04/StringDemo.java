package cn.dino.demo.Demo0801.Demo04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
    /*
    * 规定字符编码格式
    *   getBytes() 和 String()
    * */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "我爱你中国";

        // byte[] bys = s.getBytes();                  // [-26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]
        // byte[] bys = s.getBytes("UTF-8");          // [-26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]
        byte[] bys = s.getBytes("GBK");    // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
        System.out.println(Arrays.toString(bys));

        // String s1 = new String(bys);    // �Ұ����й�
        // String s1 = new String(bys, "utf-8");    // �Ұ����й�
        String s1 = new String(bys, "GBK");     // 我爱你中国
        System.out.println(s1);
    }
}
