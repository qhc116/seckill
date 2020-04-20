package edu.xjtuse.stu.seckill.controller;

import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.redis.RedisService;
import edu.xjtuse.stu.seckill.redis.prefix.UserKeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 失了秩
 * @date 2020/4/20 0:13
 * @description
 */
@Controller
@RequestMapping(("/goods"))
public class GoodsController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/list")
    public String goodsList(Model model,
                            @CookieValue(value = "token", required = false) String token,
                            HttpServletResponse response) {

        if (token == null) {
            return "login";
        } else {
            User user = redisService.get(UserKeyPrefix.token, token, User.class);
            if (user == null) {
                return "login";
            }
            //刷新缓存过期时间
            updateUserExpireTime(response, token, user);
            model.addAttribute("user", user);
            return "goods_list";
        }
    }

    private void updateUserExpireTime(HttpServletResponse response, String token, User user) {
        redisService.set(UserKeyPrefix.token, token, user);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(UserKeyPrefix.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
