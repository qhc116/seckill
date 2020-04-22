package edu.xjtuse.stu.seckill.controller;

import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.redis.RedisService;
import edu.xjtuse.stu.seckill.redis.prefix.UserKeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String goodsList(Model model, User user) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goods_list";
    }
}

