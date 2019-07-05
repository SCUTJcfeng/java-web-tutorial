package cn.jc.javawebtutorial;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import java.time.Instant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping("/timestamp")
    public String getServerInfo() {
        Map<String, Object> m = new HashMap<String, Object>();
        Long t = Instant.now().getEpochSecond();
        m.put("timestamp", t);
        return JSON.toJSONString(m);
    }
}
