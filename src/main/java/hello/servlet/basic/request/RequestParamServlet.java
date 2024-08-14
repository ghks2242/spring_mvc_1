package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * 1. 파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 클라이언트 입장에서는 형식의 차이가 있지만 서버 입장에서는 데이터 형태가 같기때문에 GET 방식의 쿼리스트링이나 POST 방식의 바디나 같이사용 가능하다

        System.out.println("----------------- 전체 파라미터 조회 start -----------------");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "= " +request.getParameter(paramName)));

        System.out.println("----------------- 전체 파라미터 조회 end -----------------");
        System.out.println();

        System.out.println("----------------- 단일 파라미터 조회 start -----------------");

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("----------------- 단일 파라미터 조회 end -----------------");
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("ok");
        System.out.println();

    }
}
