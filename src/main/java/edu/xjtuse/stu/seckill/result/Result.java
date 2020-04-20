package edu.xjtuse.stu.seckill.result;

/**
 * @author 失了秩
 * @date 2020/4/19 12:25
 * @description
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    /**
     *
     * 功能描述: 失败时调用
     *
     * @param: 错误码
     */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    /**
     *
     * 功能描述: 成功时调用
     *
     * @param: 数据/Json
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
