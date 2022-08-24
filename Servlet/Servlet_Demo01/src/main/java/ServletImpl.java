import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns = "/servletimpl",loadOnStartup = 0)  // 配置该servlet的访问路径
public class ServletImpl implements Servlet {
    private ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("服务器启动后初始化~");
    }

    public ServletConfig getServletConfig() {
        /*
         * 获取ServletConfig对象
         * */
        return servletConfig;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        // 1.获取请求方式
        String method = req.getMethod();
        // 2.根据不同请求方式，返回不同内容
        if ("GET".equals(method))
            System.out.println("ServletImpl GET请求....");
        else if ("POST".equals(method))
            System.out.println("ServletImpl POST请求....");
    }

    public String getServletInfo() {
        /*
         * 获取Servlet信息：
         *   该方法用来返回Servlet的相关信息，没有太大的作用，一般我们返回一个空字符串即可
         * */
        return null;
    }

    public void destroy() {
        System.out.println("服务器停止后调用~");
    }
}
