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

- HTTP message body 에 데이터를 직접 담아서 요청
  - HTTP API 에서 주로사용 JSON, XML, TEXT
  - 데이터 형식은 주로 JSON 사용
  - POST, PUT, PATCH
  

