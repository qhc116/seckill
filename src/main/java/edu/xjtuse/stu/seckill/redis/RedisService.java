package edu.xjtuse.stu.seckill.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 失了秩
 * @date 2020/4/17 13:48
 * @description
 */
@RestController
public class RedisService {
    @RequestMapping("/long")
    public String classlong() {
        return long.class.toString();
    }

    @RequestMapping("/Long")
    public String classLong() {
        return Long.class.toString();
    }
    @RequestMapping("/int")
    public String classint() {
        return int.class.toString();
    }

    @RequestMapping("/Integer")
    public String classInteger() {
        return Integer.class.toString();
    }
}
