package cn.jc.javawebtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloHtml {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
