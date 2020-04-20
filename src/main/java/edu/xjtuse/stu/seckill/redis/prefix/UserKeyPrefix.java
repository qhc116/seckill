package edu.xjtuse.stu.seckill.redis.prefix;

import edu.xjtuse.stu.seckill.redis.prefix.BaseKeyPrefix;

/**
 * @author 失了秩
 * @date 2020/4/20 9:17
 * @description
 */
public class UserKeyPrefix extends BaseKeyPrefix {
    public UserKeyPrefix(String prefix) {
        super(prefix);
    }

    public UserKeyPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
