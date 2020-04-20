package edu.xjtuse.stu.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 失了秩
 * @date 2020/4/17 19:50
 * @description
 */

@RestController
@RequestMapping("/redis")
public class TestConnection {
    @Autowired
    JedisPool jedisPool;

    @RequestMapping("/add")
    public String add() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set("ping", "pong");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @RequestMapping("/addnx")
    public Long addnx() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.setnx("a", "pong");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}
