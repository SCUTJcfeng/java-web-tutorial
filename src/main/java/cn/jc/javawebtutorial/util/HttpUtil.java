package cn.jc.javawebtutorial.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtil {

    @Autowired
    private RestTemplate restTemplate;

    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
