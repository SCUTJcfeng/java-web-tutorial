package cn.jc.javawebtutorial.controller;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("UserInfoService")
    private UserInfoService userInfoService;

    @Autowired
    @Qualifier("UserInfoService2")
    private UserInfoService userInfoService2;

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserInfo(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) Integer age,
            @RequestParam(value = "gender", required = true) Boolean gender) {
        UserModal user = new UserModal();
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        // return JSON.toJSONString(user);
        Integer newAge = userInfoService2.getUserAge(user);
        String newName = userInfoService2.getUserName(user);
        Boolean newGender = userInfoService2.getUserGender(user);
        Map<String, Object> m = new HashMap<>();
        m.put("name", newName);
        m.put("age", newAge);
        m.put("gender", newGender);
        return JSON.toJSONString(m);
    }
}
