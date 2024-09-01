package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("kim");


        // Jackson  라이브러리가 제공하는 objectMapper.writeValueAsString() 를 사용하면 객체를 json 문자로 변경할수있다.
        // 참고로 application/json 은 스펙상 utf-8 형식을 사용하도록 정의되어있다 그래서 스펙에서 charset=utf-8 과 같은 추가 파라미터를 지원하지않는다.
        // application/json;charset=utf-8 이라고 전달하는 것은 의미없는 파라미터를 추가한것이다.
        // response.getWriter()를 사용하면 추가 파라미터를 자동으로 추가해버린다 이때는 response.getOutputStream() 으로 출력하면 그런문제가없다.

        // {"username" : "kim", "age" : 20} 으로변경해야함
        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);

    }
}
