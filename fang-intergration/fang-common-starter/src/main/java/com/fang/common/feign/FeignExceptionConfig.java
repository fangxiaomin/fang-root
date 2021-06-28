package com.fang.common.feign;

import com.fang.common.exception.HytrixException;
import com.fang.common.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @description:  从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，
 *  被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 *  并用于构建bean定义，初始化Spring容器。
 * @projectName:fang-root
 * @see:com.fang.common.feign
 * @author:fxm
 * @createTime:2021/6/22 17:48
 * @version:1.0
 */
@Slf4j
@Configuration
public class FeignExceptionConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }

    public class UserErrorDecoder implements ErrorDecoder{

        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null ;
            ObjectMapper mapper = new ObjectMapper() ;
            //空属性处理
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            //设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //禁止使用int代表enum的order来反序列化enum
            mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
            try {
                String json = Util.toString(response.body().asReader());
                // 非业务异常包装成自定义异常类ServiceException
                if (StringUtils.isNotEmpty(json)) {

                    if(json.contains("resp_code")){
                        FeignFaildResult result = mapper.readValue(json, FeignFaildResult.class);
                        result.setStatus(response.status());
                        // 业务异常包装成自定义异常类HytrixException
                        if (result.getStatus() != HttpStatus.OK.value()) {
                            exception = new HytrixException(result.getResp_msg());
                        }else{
                            exception = feign.FeignException.errorStatus(methodKey, response);
                        }
                    }else{
                        exception = new ServiceException("程序异常");
                    }


                }else{
                    exception = feign.FeignException.errorStatus(methodKey, response);
                }

            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
            return exception;



        }
    }

}
