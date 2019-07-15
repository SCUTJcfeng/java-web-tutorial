package cn.jc.javawebtutorial.util.http;

import java.util.Map;
import org.springframework.http.HttpEntity;

public interface HttpService {

    public String get(String url, Object... uriVariables);

    public String get(String url, Map<String, ?> params);

    public String get(String url, HttpEntity<Map<String, ?>> requestEntity);

    public String get(String url, HttpEntity<Map<String, ?>> requestEntity, Object... uriVariables);

    public String get(String url, HttpEntity<Map<String, ?>> requestEntity, Map<String, ?> params);

    public String post(String url, Object... uriVariables);

    public String post(String url, Map<String, ?> params);

    public String post(String url, HttpEntity<Map<String, ?>> requestEntity);

    public String post(String url, HttpEntity<Map<String, ?>> requestEntity,
            Object... uriVariables);

    public String post(String url, HttpEntity<Map<String, ?>> requestEntity, Map<String, ?> params);

}
