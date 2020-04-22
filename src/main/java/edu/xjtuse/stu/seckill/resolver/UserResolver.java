package edu.xjtuse.stu.seckill.resolver;

import edu.xjtuse.stu.seckill.bean.User;
import edu.xjtuse.stu.seckill.redis.RedisService;
import edu.xjtuse.stu.seckill.redis.prefix.UserKeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 失了秩
 * @date 2020/4/22 21:10
 * @description
 */
@Service
public class UserResolver implements HandlerMethodArgumentResolver {

    @Autowired
    RedisService redisService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> parameterType = methodParameter.getParameterType();
        return parameterType == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest req = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse resp = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        Cookie[] cookies = req.getCookies();
        String token = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                cookie.setMaxAge(UserKeyPrefix.TOKEN_EXPIRE);
            }
        }

        if (token == null) {
            return null;
        }

        User user = redisService.get(UserKeyPrefix.token, token, User.class);
        redisService.set(UserKeyPrefix.token, token, user);
        return user;

    }
}
