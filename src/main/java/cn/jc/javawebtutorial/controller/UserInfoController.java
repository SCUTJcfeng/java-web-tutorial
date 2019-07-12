package cn.jc.javawebtutorial.controller;

import java.util.List;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;


@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserByName(@RequestParam(value = "name", required = true) String name) {
        List<UserModal> list = userInfoService.getUserByName(name);
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/getUserByGender", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserByGender(@RequestParam(value = "gender", required = true) Boolean gender) {
        List<UserModal> list = userInfoService.getUserByGender(gender);
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserById(@RequestParam(value = "id", required = true) Long id) {
        UserModal user = userInfoService.getUserById(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addUser(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) Integer age,
            @RequestParam(value = "gender", required = true) Boolean gender) {
        UserModal user = userInfoService.addUser(new UserModal(name, age, gender));
        return JSON.toJSONString(user);
    }
}
