package cn.jc.javawebtutorial.util;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapUtil {

    public static <T> T convertMap(Map<String, Object> map, Class<T> tClass) {
        return new ObjectMapper().convertValue(map, tClass);
    }
}
