# spring_mvc_1
스프링 mvc 1편

쓰레드

http 요청을 하면 tcp/ip 가 연결되고 그후 서블릿을 호출하게되는데 이때 서블릿을 호출해준다

- 애플리케이션 코드를 하나하나 순차적으로 실행하는것은 쓰레드
- 자바 메인 메서드를 처음 실행하면 main 이라는 이름의 쓰레드가 실행
- 쓰레드가 없다면 자바 애플리케이션 실행불가능
- 쓰레드는 한번에 하나의 코드라인만 실행
- 동시 처리가 필요하면 쓰레드를 추가로 생성


HTTP 요청 데이터 개요

- GET - 쿼리파라미터
  - /url?username=hello&age=20
  - 메시지 바디없이 URL 쿼리 파라미터에 데이터를 포함해서 전달
  - 예) 검색, 필터, 페이징등에서 많이 사용하는방식

- POST - HTML Form
  - content-type: application/x-www-form-urlencoded
  - 메시지 바디에 쿼리 파라미터 형식으로 전달 username=hello&age=20
  - 예) 회원가입, 상품주문, HTML Form 사용

###### [클라이언트 입장에서는 형식의 차이가 있지만 서버 입장에서는 데이터 형태가 같기때문에 GET 방식의 쿼리스트링이나 POST 방식의 바디나 같이사용 가능하다]

###### [content-type 은 HTTP 메시지의 바디데이터 형식을 지정한다. GET URL 쿼리 파라미터 형식 으로 클라이언트 에서 서버로 데이터를 전달할 때는 HTTP 메시지 바디를 사용하지않기때문에 content-type 이 없다 
###### POST-HTML Form 형식 으로 데이터를 전달하면 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기 때문에 바디에 포함된 데이터가  어떤 형태인지 꼭 content-type 에 지정해야한다] 

###### HTML FORM 을전송할때 POST 말고 PUT 이나 PATCH 를 보낼수있나요?
###### -> HTML 스펙상 FORM 데이터를 BODY 로 전송할때 POST 만 허용

- HTTP message body 에 데이터를 직접 담아서 요청
  - HTTP API 에서 주로사용 JSON, XML, TEXT
  - 데이터 형식은 주로 JSON 사용
  - POST, PUT, PATCH
  

### 템플릿 엔진으로
    지금까지 서블릿과 자바 코드만으로 HTML 을 만들었다. 서블릿 덕분에 동적으로 원하는 HTML 을 마음껏 만들수 있다.
    정적인 HTML 문서라면 화면이 계속 달라지는 회원의 저장 결과라던가, 회원 목록 같은 동적인 HTML 을 만드는 일은 불가능 할것이다.
    그런데 코드에서 보듯이 이것이 매우 복잡하고 비효율적이다. 자바코드로 HTML 을 만들어 내는것보다 차라리 HTML 문서에 동적으로 변경해야 하는 부분에
    자바코드를 넣을수있다면 더 편리할것이다.
    이것이 탬플릿 엔진이 나온 이유이다 대표적은 탬플릿 엔진으로 ( JSP, Thymeleaf, Freemarker, Velocity) 등이 있다



### 
WEB-INF 이경로안에있으면 외부에서 직접 JSP 를 호출할수 없다 항상 컨트롤러를 통해서 호출된다 

### redirect 와 forward
- 리다이렉트는 실제 클라이언트에 응답이 나갔다가 클라이언트가 redirect 경로로 다시 요청한다
따라서 클라이언트가 인지할수있고 URL 경로도 실제로 변경된다.
- 반면에 포워드는 서버내부에서 일어나는 호출이기 때문에 클라이언트가 전혀 인지하지못한다 
따라서 URL 경로가 변하지않는다.


action 에 /save 하면 절대경로로 인식되지만 / 없이 save 를 하면 현재 디렉토리에서 save 라는 패스로 생성된다
- ex) /save : http://localhost:8080/save
- ex) save : http://localhost:8080/servlet-mvc/members/save 가 된다
- 보통은 절대경로로 해주는게 더좋다고한다. 

---

### MVC 로전환 

    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
    
    위에 방법대신 편하게 아래방법으로 할수도있다.
    jsp 제공하는 문법이다
    ${} 프로퍼티 접근법이라고도 한다

    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>

###

    // out 도 그냥쓸수있는 예약어다
    for(Member member : members) {
      out.write("<tr>");
      out.write(" <td>" + member.getId() + "</td>");
      out.write(" <td>" + member.getUsername() + "</td>");
      out.write(" <td>" + member.getAge() + "</td>");
      out.write("</tr>");
    }

    // 위 문법 대신 아래 JSTL 문법으로 하면 훨씬 깔끔하다 
    // 대신 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 선언이 필요하다

    <c:forEach var="member" items="${members}" varStatus="index">
      <tr>
        <td><c:out value="${member.id}"/></td>
        <td><c:out value="${member.username}"/></td>
        <td><c:out value="${member.age}"/></td>
      </tr>
    </c:forEach>


### MVC 패턴2 정리
1. 클라이언트 호출 -> 컨트롤러 로직
2. 비즈니스 로직 데이터접근
3. 모델로 데이터전달
4. 뷰 로직 
5. 뷰 로직에서 모델에 데이터 참조하여 화면구성
6. 응답

jsp 편의로 제공하는문법 ${} 프로퍼티 접근법 과 JSTL 문법이존재

MVC 덕분에 컨트롤러 로직과 뷰 로직을 확실하게 분리하였다 
향후 화면 수정이 발생하면 뷰로직만 변경하면된다.
---
### MVC 패턴의 한계
  MVC 패턴 을 적용한덕분에 컨트롤러의 역할과 뷰를 렌더링 하는 역할을 명확하게 구분할수있다.
  그런데 컨트롤러에 중복이많고 사용하지않는 코드들이 많이보인다.
  
1. forward 중복
   1. view 로 이동하는 코드가 항상 중복 호출되어야한다. 물론 메서드로 공통화해도 되지만 해당 메서드도 직접 호출해야한다.
   2. ViewPath 중복 

          String viewPath = "/WEB-INF/views/new-form.jsp" 같이 "/WEB-INF/views/" 이부분과 ".jsp" 부분이 반복된다
   3. 사용하지않는 코드
   
          HttpServletRequest request 와 HttpServletResponse response 는 사용할때도 있고 사용하지않을때도 있다
          그리고 테스트 케이스를 작성하기도 어렵다
   4. 공통처리가 어렵다

          기능이 복잡해질수록 컨트롤러에서 공통으로 처리해야하하는 부분이 점점더 증가할것이다. 단순히 공통기능을 메서드로 뽑으면될거같지만
          결과적으로 해당 메서드를 항상 호출해야하고, 실수로 호출하지 않으면 문제가될것이다. 그리고 호출하는것 자체도 중복이다.
   
   5. 정리하면 공통처리가 어렵다는문제가있다

          이문제를 해결하기위해 컨트롤러 호출전에 먼저 공통 기능을 처리해야한다. 소위 '수문장 역할' 을 하는 기능이 필요하다
          "프론트 컨트롤러 패턴" 을 도입하면 이런문제를 깔끔하게 해결할수있다. (들어오는 입구를 하나로) ‼️필터랑은 다르다 ‼️
          스프링 MVC 핵심도 바로 이 프론트 컨트롤러이다.

---
### 프론트 컨트롤러 

  1. 도입전
     
          ClientA => ControllerA
          ClientB => ControllerB
          ClientC => ControllerC
  2. 도입후
     
          ClientA ↘︎︎    ↗  ControllerA
          ClientB → 공통 →  ControllerB
          ClientC ↗    ︎↘︎  ControllerC

     1. 프론트 컨트롤러 패턴특징
        1. 프론트 컨트롤러 서블릿 하나로 클라이언트의 요청을 받음
        2. 프론트 컨트롤러가 요청에 맞는 컨트롤러를 찾아서 호출
        3. 입구를 하나로!
        4. 공통 처리가능
        5. 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도됨.

  스프링 웹 MVC 와 프론트 컨트롤러 <br>
  스프링 웹 MVC 의 핵심도 바로 FrontController <br>
  스프링 웹 MVC 의 DispatcherServlet 이 FrontController 패턴으로 구현되어있음

### Modle 추가

#### 서블릿 종속성 제거
컨트롤러 입장에서는 HttpServletRequest, HttpServletResponse 가 필요없다.
요청 파라미터 정보는 자바의 Map 으로 넘기도록하면 컨트롤러에서는 서블릿 기술을 몰라도 동작할수있다.
그리고 request 객체를 Model로 사용하는 대신에 별도의 Model 객체를 만들어서 변환하면된다.
이렇게하면 구현 코드도 매우 단순해지고, 테스트 코드 작성이쉽다

#### 뷰 이름 중복제거
컨트롤러에서 지정하는 뷰 이름에 중복이 있는것을 확인할수있다.
컨트롤러는 뷰의 논리 이름을 반환하고 실제 물리 위치의 이름은 프론트 컨트롤러에서 처리하도록 단순화하자.
이렇게 해두면 향후 뷰의 폴더 위치가 함께 이동해도 프론트 컨트롤러만 고치면된다.

            물리적위치                   논리이름
    /WEB-INF/views/new-form.jsp    -> new-form
    /WEB-INF/views/save-result.jsp -> save-result
    /WEB-INF/views/members.jsp     -> members


#### ModelView
지금 까지 컨트롤러에서 서블릿에 종속적인 HttpServletRequest 를 사용했다.
그리고 Model도 'request.setAttribute()' 를 통해 데이터를 저장하고 뷰에 전달했다.
서블릿의 종속성을 제거하기위해 Model을 직접만들고, 추가로 View 이름까지 전달하는 객체를 만들어보자.
(이번 버전에서는 컨트롤러에서 HttpServletRequest 를 사용할수없다. 따라서 직접 request.setAttribute() 를 호출할수도 없다. 따라서 Model 이 별도로 필요하다)

#### 뷰 리졸버
MyView view = viewResolver(viewName) 
컨트롤러가 반환한 논리 뷰 이름을 실제 물리 뷰 경로로 변경한다. 그리고 실제 물리 경로가 있는 MyView 객체를 반환한다.
- 논리뷰이름 : members
- 물리뷰경로 : /WEB-INF/views/members.jsp
- view.render(mv.getModel(), request, response)
- 뷰 객체를 통해서 HTML 화면을 랜더링 한다
- 뷰 객체의 render() 는 모델 정보도 함께 받는다.
- JSP 는 request.getAttribute() 로 데이터를 조회하기 때문에 모델의 데이터를 꺼내서 request.setAttribute()로 담아둔다
- JSP로 포워드해서 JSP 를 랜더링한다.