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
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "test_user_agent");
        HttpEntity<Map<String, ?>> requestGetEntity = new HttpEntity<>(headers);
        HttpEntity<Map<String, ?>> requestPostEntity = new HttpEntity<>(map, headers);

        System.out.println(httpUtil.get(TEST_GET_URL));
        System.out.println(httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", name, age));
        System.out.println(httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", map));
        System.out.println(httpUtil.get(TEST_GET_URL, requestGetEntity));
        System.out.println(
                httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", requestGetEntity, name, age));
        System.out.println(
                httpUtil.get(TEST_GET_URL + "?name={name}&age={age}", requestGetEntity, map));

        System.out.println(httpUtil.post(TEST_POST_URL));
        System.out.println(httpUtil.post(TEST_POST_URL + "?name={name}&age={age}", name, age));
        System.out.println(httpUtil.post(TEST_POST_URL + "?name={name}&age={age}", map));
        System.out.println(httpUtil.post(TEST_POST_URL, requestPostEntity));
        System.out.println(httpUtil.post(TEST_POST_URL + "?name={name}&age={age}",
                requestPostEntity, name, age));
        System.out.println(
                httpUtil.post(TEST_POST_URL + "?name={name}&age={age}", requestPostEntity, map));
    }

}
