package edu.xjtuse.stu.seckill.service;

import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.mapper.UserMapper;
import edu.xjtuse.stu.seckill.redis.RedisService;
import edu.xjtuse.stu.seckill.redis.prefix.UserKeyPrefix;
import edu.xjtuse.stu.seckill.result.CodeMsg;
import edu.xjtuse.stu.seckill.result.Result;
import edu.xjtuse.stu.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 失了秩
 * @date 2020/4/17 17:39
 * @description
 */
@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    @Autowired
    RedisService redisService;


    public Result login(HttpServletResponse response, LoginVo loginVo) {
        User user = mapper.findUserById(Long.parseLong(loginVo.getMobile()));

        if (user == null) {
            return Result.error(CodeMsg.UNREFISTER_ERROR);
        } else if (!loginVo.getPassword().equals(user.getPassword())) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        String token = UUID.randomUUID().toString();
        addCookie(response, token, user);
        return Result.success(user);
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKeyPrefix.token, token, user);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(UserKeyPrefix.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
