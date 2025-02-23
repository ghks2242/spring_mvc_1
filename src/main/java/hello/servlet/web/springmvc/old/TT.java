package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component  // Spring 빈으로 등록될 수 있도록 @Component 포함
public @interface TT {
}
