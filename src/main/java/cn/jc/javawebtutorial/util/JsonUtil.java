package cn.jc.javawebtutorial.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {

    public static <T> T parseString(String jsonString) {
        T TObject = JSON.parseObject(jsonString, new TypeReference<T>() {
        });
        return TObject;
    }
}
