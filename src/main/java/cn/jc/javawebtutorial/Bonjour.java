package cn.jc.javawebtutorial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bonjour")
@RestController
public class Bonjour {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "Get Bonjour Method";
    }

    @RequestMapping(value = "/bon", method = RequestMethod.GET)
    public String getBon() {
        return "Get bonjour/bon Method";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postMethod() {
        return "Post Bonjour Method";
    }
}