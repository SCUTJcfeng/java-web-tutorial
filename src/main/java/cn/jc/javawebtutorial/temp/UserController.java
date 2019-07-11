package cn.jc.javawebtutorial.temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
