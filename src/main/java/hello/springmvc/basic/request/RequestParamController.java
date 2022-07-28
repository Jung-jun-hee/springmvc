package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 이건 그냥 HTTPServlet이 제공하는 기능을 사용하는것
        req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        resp.getWriter().write("ok");
    }

    @RequestMapping("/request-parma-v2")
    public String requestParamV2(@RequestParam("username") String userName, @RequestParam("age") int userAge){
        log.info("username={}, age={}", userName,userAge);
        return "ok";
    }

    @RequestMapping("/request-parma-v3")
    public String requestParamV3(@RequestParam String userName, @RequestParam int userAge){
        log.info("username={}, age={}", userName,userAge);
        return "ok";
    }

    @RequestMapping("/request-parma-v4") // String, int, Integer 등의 단순 타입이라면 @RequestParam도 생략 가능하다.
    public String requestParamV4(String userName, int userAge){
        log.info("username={}, age={}", userName,userAge);
        return "ok";
    }

    @RequestMapping("/request-parma-required") // required가 true 면 무조건 값이 보내져야한다 만약 없으면 에러가 뜬다. 필수값을 지정할 수 있다. 빈문자 통과 조심
    public String requestrequired(@RequestParam(required = true) String userName, @RequestParam(required = false) int userAge){
        log.info("username={}, age={}", userName,userAge);
        return "ok";
    }

    @RequestMapping("/request-parma-ㅡ메") // Map으로도 파라미터를 조회할 수 있다. 파라미터의 값이 1개가 확실하면 Map을 사용해도 되지만 그렇지 않으면 MultiValueMap을 사용하자
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"));
        return "ok";
    }
}
