package cn.jc.javawebtutorial.controller;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyDBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping("/db")
    public String getDB() {
        String sql = "SELECT `exchange`, `symbol` from `kline` LIMIT 5";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> m : list) {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            }
        }
        return JSON.toJSONString(list);
    }
}
