package edu.xjtuse.stu.seckill.vo;

import edu.xjtuse.stu.seckill.volidator.Mobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author 失了秩
 * @date 2020/4/18 13:26
 * @description
 */
public class LoginVo {
    @NotNull
    @Mobile
    String mobile;

    @NotNull
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
