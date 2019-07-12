package cn.jc.javawebtutorial.util;

import org.springframework.web.client.RestTemplate;

public class HttpUtil {

    public static String get(RestTemplate restTemplate, String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
