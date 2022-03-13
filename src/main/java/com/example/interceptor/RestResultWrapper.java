package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
*此注解针对controller层的类做增强功能，即对加了@RestController注解的类进行处理
*/

@ControllerAdvice(basePackageClasses =TestController.class)
//@ControllerAdvice(annotations = RestController.class)
public class RestResultWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
          System.out.println("传过的值"+body);
            //定义一个统一的返回类
            RestResult responseResult = new RestResult( "0", body, "success");
             //如果handler处理类的返回类型是String（即控制层的返回值类型），为了保证一致性，这里需要将ResponseResult转回去
            if(body instanceof String) {
                return JSONObject.toJSONString(responseResult);
            }
           //封装后的数据返回到前端页面
            return JSONObject.toJSON(responseResult);

    }
}
