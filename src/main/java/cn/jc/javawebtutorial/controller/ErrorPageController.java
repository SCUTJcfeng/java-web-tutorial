package cn.jc.javawebtutorial.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
public class ErrorPageController implements ErrorController {

    private static final String PATH = "/error";
    private Logger logger = LogManager.getLogger(ErrorPageController.class.getName());

    @RequestMapping
    public Object error(HttpServletResponse resp, HttpServletRequest req) {
        logger.error(req.getRequestURI());
        return "Error happens";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
