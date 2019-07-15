package cn.jc.javawebtutorial.util;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import cn.jc.javawebtutorial.util.http.HttpService;

@Component
public class HttpUtil implements HttpService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String get(String url, Object... uriVariables) {
        return restTemplate.getForObject(url, String.class, uriVariables);
    }

    @Override
    public String get(String url, Map<String, ?> params) {
        return restTemplate.getForObject(url, String.class, params);
    }

    @Override
    public String get(String url, @Nullable HttpEntity<Map<String, Object>> requestEntity,
            Object... uriVariables) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                requestEntity, String.class, uriVariables);
        return responseEntity.getBody();
    }

    @Override
    public String get(String url, @Nullable HttpEntity<Map<String, Object>> requestEntity,
            Map<String, ?> params) {
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, params);
        return responseEntity.getBody();
    }

    // public String post(String url) {
    // return restTemplate.postForObject(url, request, String.class, uriVariables)
    // }
}
