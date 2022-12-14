package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    // 요청 파라미터로 기본, 헤더 조회하기
    @RequestMapping("/headers")
    public String headers(HttpServletRequest req ,
                          HttpServletResponse resp,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host, @CookieValue(value = "myCookie", required = false) String cookie) {
        // MutiValueMap은 Map과 유사한데, 하나의 키에 여러 값을 받을 수 있다.
        // map.add("keyA" , "value1");
        // map.add("keyA" , "value2");
        // keyA를 꺼내면 배열이 반환된다 .[value1, value2]

        log.info("request={}", req);
        log.info("response={}", resp);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("header host={}", host);
        log.info("headerMap={}", headerMap);
        log.info("myCookie={}", cookie);

        return "ok";
    }
}
