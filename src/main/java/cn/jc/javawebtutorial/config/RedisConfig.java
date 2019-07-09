package cn.jc.javawebtutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    private String host;

    private Integer port;

    private Integer database;

    private Integer timeout;

    private String password;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Long maxWait;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;

}