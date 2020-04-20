package edu.xjtuse.stu.seckill.redis;

import com.alibaba.fastjson.JSON;
import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.redis.prefix.KeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 失了秩
 * @date 2020/4/17 13:48
 * @description
 */

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String redisvalue = beanToString(value);
            if(redisvalue == null || redisvalue.length() <= 0) {
                return false;
            }
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            int seconds =  prefix.getExpireSeconds();
            if(seconds <= 0) {
                jedis.set(realKey, redisvalue);
            }else {
                jedis.setex(realKey, seconds, redisvalue);
            }
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            String res = jedis.get(realKey);
            T t = string2Bean(res, clazz);
            return t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private <T> T string2Bean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T) str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T) Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }
}
