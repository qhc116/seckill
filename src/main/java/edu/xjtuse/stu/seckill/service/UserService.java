package edu.xjtuse.stu.seckill.service;

import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.mapper.UserMapper;
import edu.xjtuse.stu.seckill.result.CodeMsg;
import edu.xjtuse.stu.seckill.result.Result;
import edu.xjtuse.stu.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 失了秩
 * @date 2020/4/17 17:39
 * @description
 */
@Service
public class UserService {
    @Autowired
    UserMapper mapper;


    public Result login(LoginVo loginVo) {
        User user = mapper.findUserById(Long.parseLong(loginVo.getMobile()));

        if (user == null) {
            return Result.error(CodeMsg.UNREFISTER_ERROR);
        } else if (!loginVo.getPassword().equals(user.getPassword())) {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        return Result.success(user);
    }
}
