package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*  @Controller는 반환 값이 String이면 이것이 뷰(View)이름으로 인식된다.
*  그래서 해당 뷰를 찾고 뷰가 렌더링이 된다 (String이라는 뷰를 찾는다)
*  @RestController 는 반환 값으로 뷰를 찾는 것이 아니라
*  HTTP 메시지 바디에 바로 입력한다.
*  따라서 실행 결과로 문자열 그 자체의 메시지를 받을 수 있다.
 */

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "String";
        log.trace("trace log= {}" , name);
        log.debug("trace log= {}" , name);
        log.warn("trace log= {}" , name);
        log.error("trace log= {}" , name);
        log.info("info log={}", name);

        return "ok";
    }
}
