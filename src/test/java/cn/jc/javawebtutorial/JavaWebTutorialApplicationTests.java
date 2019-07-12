package cn.jc.javawebtutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.util.HttpUtil;
import cn.jc.javawebtutorial.util.JsonUtil;
import cn.jc.javawebtutorial.util.MapUtil;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaWebTutorialApplicationTests {

    private static final String BASE_URL = "http://127.0.0.1:8888";
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

}
