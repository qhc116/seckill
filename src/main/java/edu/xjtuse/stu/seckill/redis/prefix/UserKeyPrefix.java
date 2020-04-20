package edu.xjtuse.stu.seckill.redis.prefix;

import edu.xjtuse.stu.seckill.redis.prefix.BaseKeyPrefix;

/**
 * @author 失了秩
 * @date 2020/4/20 9:17
 * @description
 */
public class UserKeyPrefix extends BaseKeyPrefix {

    public static final int TOKEN_EXPIRE = 3600*24;

    private UserKeyPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKeyPrefix token = new UserKeyPrefix(TOKEN_EXPIRE, "token");
}
