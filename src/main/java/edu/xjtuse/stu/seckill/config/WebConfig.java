package edu.xjtuse.stu.seckill.config;

import edu.xjtuse.stu.seckill.resolver.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/4/22 21:11
 * @description
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    UserResolver userResolver;

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userResolver);
    }
}
