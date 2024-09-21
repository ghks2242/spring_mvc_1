package hello.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// war 파일로 배포를 진행해야 하는 경우가 있을 수 있다. 이럴 경우 SpringBootServletInitializer를 상속받으면 된다.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletApplication.class);
	}

}
