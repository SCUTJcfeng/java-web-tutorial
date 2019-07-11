package cn.jc.javawebtutorial.temp;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import java.time.Instant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "hello controller api")
public class HelloController {

    @ApiOperation(value = "返回欢迎", notes = "测试服务器连接是否正常")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/timestamp", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getServerInfo() {
        Map<String, Object> m = new HashMap<>();
        m.put("timestamp", Instant.now().getEpochSecond());
        return JSON.toJSONString(m);
    }
}
