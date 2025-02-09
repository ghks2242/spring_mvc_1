package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF 이경로안에있으면 외부에서 직접 JSP 를 호출할수 없다 항상 컨트롤러를 통해서 호출된다
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 해당경로로 이동할거다 명시
        // forward 를 호출시 실질적으로 해당경로로 이동
        // [** 다른 서블릿이나 jsp 로 이동할수있는기능 서버 내부에서 다시 호출이 발생한다]
        dispatcher.forward(request, response);

    }




}
