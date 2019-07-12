package cn.jc.javawebtutorial.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

public class HttpUtil {

    public static JSONObject get(RestTemplate restTemplate, String url) {
        String jsonString = restTemplate.getForObject(url, String.class);
        return JSON.parseObject(jsonString);
    }
}
