package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF 이경로안에있으면 외부에서 직접 JSP 를 호출할수 없다 항상 컨트롤러를 통해서 호출된다
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 해당경로로 이동할거다 명시
        // forward 를 호출시 실질적으로 해당경로로 이동
        // [** 다른 서블릿이나 jsp 로 이동할수있는기능 서버 내부에서 다시 호출이 발생한다]
        dispatcher.forward(request, response);
    }
}
