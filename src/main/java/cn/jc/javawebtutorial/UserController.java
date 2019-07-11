package cn.jc.javawebtutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;

class VipUser implements Serializable {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "age")
    private Integer age;

    @JSONField(serialize = false)
    private Map<String, Object> map = new HashMap<>();
    private static final long serialVersionUID = 1L;

    public VipUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public VipUser() {

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

    @RequestMapping(value = "/user", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserList() {
        ArrayList<VipUser> list = new ArrayList<>();
        list.add(new VipUser("jack", 18));
        list.add(new VipUser("jackson", 11));
        return JSON.toJSONString(list);
    }
}


@RestController
class UserInfoController {

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
