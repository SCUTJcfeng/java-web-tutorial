package cn.jc.javawebtutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.util.HttpUtil;
import cn.jc.javawebtutorial.util.JsonUtil;
import cn.jc.javawebtutorial.util.MapUtil;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaWebTutorialApplicationTests {

    private static final String BASE_URL = "http://127.0.0.1:8888";
    private static final String TEST_BASE_URL = "http://127.0.0.1:5000/test";
    private static final String TEST_GET_URL = TEST_BASE_URL + "/get";
    private static final String TEST_POST_URL = TEST_BASE_URL + "/post";
    private static final String USER_BASE_URL = BASE_URL + "/user";

    @Autowired
    private HttpUtil httpUtil;

    private Boolean checkUserInfoNull(UserModal user) {
        assertNotNull(user.getName());
        assertNotNull(user.getGender());
        assertNotNull(user.getAge());
        assertNotNull(user.getId());
        return true;
    }

    @Test
    public void getUserByNameTest() {
        String jsonString = httpUtil.get(USER_BASE_URL + "/getUserByName?name=jack");
        System.out.println(jsonString);
        List<Map<String, Object>> list = JsonUtil.parseString(jsonString);
        for (Map<String, Object> m : list) {
            UserModal user = MapUtil.convertMap(m, UserModal.class);
            checkUserInfoNull(user);
        }
    }

    @Test
    public void httpUtilTest() {
        String name = "jack";
        Integer age = 18;
        String result = httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", name, age);
        System.out.println(result);

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        String result2 = httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", map);
        System.out.println(result2);

        String result3 = httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", null, map);
        System.out.println(result3);

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "test_user_agent");
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(headers);
        String result4 = httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", requestEntity, map);
        System.out.println(result4);
    }

}
