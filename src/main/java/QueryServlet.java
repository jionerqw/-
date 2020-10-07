import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//4:编写后台业务逻辑
@WebServlet("/queryUsername")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1:接收请求获取参数
        String username = request.getParameter("username");
        //2:处理业务逻辑
        Result result = new Result();
        if("jack".equals(username)){
            //3:都需要是json数据
            result.setMsg("该邮箱地址已被注册");
            result.setCode(1);
            //返回已注册
        }else{
            result.setMsg("恭喜，该邮件地址可以注册");
            result.setCode(0);
            //返回未注册
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(new ObjectMapper().writeValueAsString(result));

    }
}
