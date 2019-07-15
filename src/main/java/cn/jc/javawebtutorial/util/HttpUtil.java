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

    public ResponseEntity<String> exchangeGet(String url,
            @Nullable HttpEntity<Map<String, ?>> requestEntity, Object... uriVariables) {
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class,
                uriVariables);
    }

    public ResponseEntity<String> exchangeGet(String url,
            @Nullable HttpEntity<Map<String, ?>> requestEntity, Map<String, ?> params) {
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, params);
    }

    public ResponseEntity<String> exchangePost(String url,
            @Nullable HttpEntity<Map<String, ?>> requestEntity, Object... uriVariables) {
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class,
                uriVariables);
    }

    public ResponseEntity<String> exchangePost(String url,
            @Nullable HttpEntity<Map<String, ?>> requestEntity, Map<String, ?> params) {
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, params);
    }

    @Override
    public String get(String url, Object... uriVariables) {
        ResponseEntity<String> responseEntity = exchangeGet(url, null, uriVariables);
        return responseEntity.getBody();
    }

    @Override
    public String get(String url, Map<String, ?> params) {
        ResponseEntity<String> responseEntity = exchangeGet(url, null, params);
        return responseEntity.getBody();
    }

    @Override
    public String get(String url, HttpEntity<Map<String, ?>> requestEntity) {
        ResponseEntity<String> responseEntity = exchangeGet(url, requestEntity);
        return responseEntity.getBody();
    }

    @Override
    public String get(String url, HttpEntity<Map<String, ?>> requestEntity,
            Object... uriVariables) {
        ResponseEntity<String> responseEntity = exchangeGet(url, requestEntity, uriVariables);
        return responseEntity.getBody();
    }

    @Override
    public String get(String url, HttpEntity<Map<String, ?>> requestEntity, Map<String, ?> params) {
        ResponseEntity<String> responseEntity = exchangeGet(url, requestEntity, params);
        return responseEntity.getBody();
    }

    @Override
    public String post(String url, Object... uriVariables) {
        ResponseEntity<String> responseEntity = exchangePost(url, null, uriVariables);
        return responseEntity.getBody();
    }

    @Override
    public String post(String url, Map<String, ?> params) {
        ResponseEntity<String> responseEntity = exchangePost(url, null, params);
        return responseEntity.getBody();
    }

    @Override
    public String post(String url, HttpEntity<Map<String, ?>> requestEntity) {
        ResponseEntity<String> responseEntity = exchangePost(url, requestEntity);
        return responseEntity.getBody();
    }

    @Override
    public String post(String url, HttpEntity<Map<String, ?>> requestEntity,
            Object... uriVariables) {
        ResponseEntity<String> responseEntity = exchangePost(url, requestEntity, uriVariables);
        return responseEntity.getBody();
    }

    @Override
    public String post(String url, HttpEntity<Map<String, ?>> requestEntity,
            Map<String, ?> params) {
        ResponseEntity<String> responseEntity = exchangePost(url, requestEntity, params);
        return responseEntity.getBody();
    }

}
