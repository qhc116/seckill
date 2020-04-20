package edu.xjtuse.stu.seckill.redis.prefix;

/**
 * @author 失了秩
 * @date 2020/4/17 22:38
 * @description
 */
public interface KeyPrefix {
    String getPrefix();
    int getExpireSeconds();
}
