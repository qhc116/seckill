package edu.xjtuse.stu.seckill.redis.prefix;

import edu.xjtuse.stu.seckill.redis.prefix.KeyPrefix;

/**
 * @author 失了秩
 * @date 2020/4/17 23:12
 * @description
 */
public abstract class BaseKeyPrefix implements KeyPrefix {
    private int expireSeconds;

    private String prefix;

    public BaseKeyPrefix(String prefix) {//0代表永不过期
        this(0, prefix);
    }

    public BaseKeyPrefix( int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }

    @Override
    public int getExpireSeconds() {
        return expireSeconds;
    }
}
