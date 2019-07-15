package cn.jc.javawebtutorial.util.http;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.lang.Nullable;

public interface HttpService {

    public String get(String url, Object... uriVariables);

    public String get(String url, Map<String, ?> params);

    public String get(String url, @Nullable HttpEntity<Map<String, Object>> requestEntity,
            Object... uriVariables);

    public String get(String url, @Nullable HttpEntity<Map<String, Object>> requestEntity,
            Map<String, ?> params);
}
