package edu.xjtuse.stu.seckill.controller;

import edu.xjtuse.stu.seckill.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 失了秩
 * @date 2020/4/20 0:13
 * @description
 */
@Controller
@RequestMapping(("/goods"))
public class GoodsController {

    @RequestMapping("/list")
    public String goodsList(Model model, User user) {
        model.addAttribute("user", user);
        return "goods_list";
    }
}
