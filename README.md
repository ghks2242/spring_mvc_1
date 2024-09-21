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




