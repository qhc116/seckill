package edu.xjtuse.stu.seckill.controller;

import edu.xjtuse.stu.seckill.result.CodeMsg;
import edu.xjtuse.stu.seckill.result.Result;
import edu.xjtuse.stu.seckill.vo.LoginVo;
import edu.xjtuse.stu.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author 失了秩
 * @date 2020/4/17 17:34
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @RequestMapping("/loginpage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpServletResponse response, @Valid LoginVo loginVo){
        return service.login(response, loginVo);
    }
}
