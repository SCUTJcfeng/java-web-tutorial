package cn.jc.javawebtutorial;

import java.util.List;
// import java.io.Serializable;
import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

import com.alibaba.fastjson.JSON;
// import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class User {

    private String name;

    private Integer age;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Group {

    private Integer id;
    private String name;
    private List<User> list = new ArrayList<>();

    public void addUser(User user) {
        list.add(user);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return list;
    }
}

@RestController
public class GroupController {

    @RequestMapping(value = "/group", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserList() {
        Group g = new Group();
        g.setId(1);
        g.setName("group A");
        g.addUser(createUser("jack", 18));
        g.addUser(createUser("jackson", 15));
        return JSON.toJSONString(g);

        // ArrayList<User> list = new ArrayList<>();
        // list.add(new User("jack", 18));
        // list.add(new User("jackson", 11));
        // return JSON.toJSONString(list);
    }

    private User createUser(String name, Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }
}