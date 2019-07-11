package cn.jc.javawebtutorial.temp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {

    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String getData(@RequestParam(value = "name", required = true) String name) {
        return "name is " + name;
    }
}
