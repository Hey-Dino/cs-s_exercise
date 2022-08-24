package com.dino;

import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp_data02")
public class ResponseData02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.读取文件
        FileInputStream fis = new FileInputStream("C:\\Users\\Dino\\Desktop\\药水哥.gif");
        // 2.获取resp字节输出流
        ServletOutputStream os = resp.getOutputStream();
        // 3.完成流的copy
        /*byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            os.write(buff, 0, len);
        }*/
        // 利用外部工具类
        IOUtils.copy(fis, os);
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
