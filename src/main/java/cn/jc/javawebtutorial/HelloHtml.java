package cn.jc.javawebtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHtml {

    @RequestMapping("/hi")
    public String hello() {
        return "hello";
    }
}
