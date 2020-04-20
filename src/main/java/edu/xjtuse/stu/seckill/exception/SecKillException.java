package edu.xjtuse.stu.seckill.exception;

import edu.xjtuse.stu.seckill.result.CodeMsg;

/**
 * @author 失了秩
 * @date 2020/4/19 20:16
 * @description
 */
public class SecKillException extends RuntimeException {

    private CodeMsg codeMsg;

    public SecKillException(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
