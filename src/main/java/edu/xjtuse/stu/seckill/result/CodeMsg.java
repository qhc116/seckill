package edu.xjtuse.stu.seckill.result;

/**
 * @author 失了秩
 * @date 2020/4/19 12:30
 * @description
 */
public class CodeMsg {
    private int code;
    private String msg;

    /**
     *     错误码
     */



    //服务器错误
    public static CodeMsg SERVER_ERROR = new CodeMsg(500200, "服务器错误");;


    // 用户登录模块
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_FORM_ERROR = new CodeMsg(500211, "密码格式错误");
    public static CodeMsg MOBILE_FORM_ERROR = new CodeMsg(500212, "手机号格式错误");
    public static CodeMsg FORM_ERROR = new CodeMsg(500213, "表单错误");
    public static CodeMsg UNREFISTER_ERROR = new CodeMsg(500214, "手机号未注册");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    public static CodeMsg BIND_ERROR = new CodeMsg(500216, "参数校验错误");



    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
