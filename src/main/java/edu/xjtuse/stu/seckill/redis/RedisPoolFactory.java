package edu.xjtuse.stu.seckill.redis;

import edu.xjtuse.stu.seckill.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 失了秩
 * @date 2020/4/17 19:46
 * @description
 */
@Component
public class RedisPoolFactory {
    @Autowired
    RedisConfig config;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(config.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(config.getPoolMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(config.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(jedisPoolConfig, config.getHost(), config.getPort(),
                config.getTimeout()*1000, config.getPassword(), 0);
        return jp;
    }
}
