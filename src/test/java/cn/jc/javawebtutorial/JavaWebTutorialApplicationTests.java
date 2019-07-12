package cn.jc.javawebtutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.util.HttpUtil;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaWebTutorialApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getUserByNameTest() {
        String url = "http://127.0.0.1:8888/getUserByName?name=jack";
        String jsonString = HttpUtil.get(restTemplate, url);
        List<UserModal> list = JSON.parseObject(jsonString, new TypeReference<List<UserModal>>() {
        });
        System.out.println(JSON.toJSONString(list));
    }

}
