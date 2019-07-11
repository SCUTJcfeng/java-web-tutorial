package cn.jc.javawebtutorial.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping
    public String error() {
        return "Error happens";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
