package cn.jc.javawebtutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
class Config {

    @Autowired
    RedisConfig r;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(r.getMinIdle());
        jedisPoolConfig.setMaxIdle(r.getMaxIdle());
        jedisPoolConfig.setMaxTotal(r.getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(r.getMaxWait());
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setJmxEnabled(true);
        System.out.println(r.getHost());
        System.out.println(r.getPort());
        System.out.println(r.getDatabase());
        return new JedisPool(jedisPoolConfig, r.getHost(), r.getPort(), r.getTimeout(), r.getPassword());
    }
}