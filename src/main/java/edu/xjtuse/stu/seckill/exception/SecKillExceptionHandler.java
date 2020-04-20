package edu.xjtuse.stu.seckill.exception;

import edu.xjtuse.stu.seckill.result.CodeMsg;
import edu.xjtuse.stu.seckill.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/4/19 20:20
 * @description
 */

@ControllerAdvice
@ResponseBody
public class SecKillExceptionHandler {
    @ExceptionHandler
    public Result<String> exceptionHandler(Exception e) {
        if (e instanceof SecKillException) {
            SecKillException secKillException = (SecKillException) e;
            return Result.error(secKillException.getCodeMsg());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();
            ObjectError error = allErrors.get(0);
            String msg = error.getDefaultMessage();
            CodeMsg.BIND_ERROR.setMsg(msg);
            return Result.error(CodeMsg.BIND_ERROR);
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
