import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1、精确匹配：一个urlPatterns可以配置多个访问路径
*   如urlPatterns = {"/myservlet01", "/myservlet02"}
*
* 2、目录匹配：访问路径中可以包括通配符*
*   如urlPatterns = "/user/*"，则该目录下都能访问到该Servlet，如/user、/user/abc、/user/a/b
*
* 3、拓展名匹配：如urlPatterns = "*.do"，路径前不能有前缀
*
* 4、任意匹配：如urlPatterns = "/*" 或 "/"
*   "/*" 会覆盖其他servlets
*   "/" 不会覆盖其它servlet
* */
@WebServlet(urlPatterns = "/myservlet",loadOnStartup = 0)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet GET请求....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet POST请求....");
    }
}
