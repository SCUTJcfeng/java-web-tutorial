package cn.jc.javawebtutorial.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.impl.UserDaoImpl;

@RestController
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<UserModal> queryUser(@RequestParam(value = "name", required = true) String name) {
        return userDaoImpl.selectUserByName(name);
    }

}
