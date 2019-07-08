package cn.jc.javawebtutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class User implements Serializable {
    private String name;
    private Integer age;
    private Map<String, Object> map = new HashMap<>();
    private static final long serialVersionUID = 1L;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(map);
    }

    public void setName(String name) {
        this.name = name;
        map.put("name", name);
    }

    public void setAge(Integer age) {
        this.age = age;
        map.put("age", age);
    }
}

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserList() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        list.add(new User("jack", 18).getMap());
        list.add(new User("jackson", 11).getMap());
        return JSON.toJSONString(list);
    }
}