package com.fang.fangoauth.config;

import com.fang.fangoauth.enhancer.JwtTokenEnhancer;
import com.fang.fangoauth.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @description:  添加使用JWT存储令牌的配置：
 * @version:1.0
 */
@Configuration
public class JwtTokenStoreConfig {

    public  static final String public_cert = "public.cert";

    @Bean
    @Primary
    public TokenStore jwtTokenStore() throws IOException {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    //创建一个JwtTokenEnhancer实例：
    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() throws IOException {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 配置jwt使用的密钥
        jwtAccessTokenConverter.setSigningKey("fang_key");

       /* Resource resource = new ClassPathResource(public_cert);
        String publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        jwtAccessTokenConverter.setVerifier(new RsaVerifier(publicKey));*/
        return jwtAccessTokenConverter;
    }

}
