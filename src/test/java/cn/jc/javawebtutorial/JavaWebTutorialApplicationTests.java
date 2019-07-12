package cn.jc.javawebtutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.util.HttpUtil;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaWebTutorialApplicationTests {

    @Autowired
    private HttpUtil httpUtil;

    @Test
    public void getUserByNameTest() {
        String url = "http://127.0.0.1:8888/getUserByName?name=jack";
        String jsonString = httpUtil.get(url);
        List<Map<String, Object>> list =
                JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
                });
        for (Map<String, Object> m : list) {
            ObjectMapper mapper = new ObjectMapper();
            UserModal user = mapper.convertValue(m, UserModal.class);
            assertNotNull(user.getName());
            assertNotNull(user.getGender());
            assertNotNull(user.getAge());
            assertNotNull(user.getId());
            System.out.println(JSON.toJSONString(user));
        }
        System.out.println(JSON.toJSONString(list));
    }

}
