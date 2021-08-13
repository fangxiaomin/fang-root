package com.fang.fangoauth.config;

import com.fang.fangoauth.enhancer.JwtTokenEnhancer;
import com.fang.fangoauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:   授权服务器配置中指定令牌的存储策略为Redis：
 * @projectName:fang-root
 * @see:com.fang.fangoauth.config
 * @author:fxm
 * @createTime:2021/8/10 15:46
 * @version:1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //密码加密器

    @Autowired
    private PasswordEncoder passwordEncoder;

    //认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;

    //用户信息相关的实现
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;

    /**
     * 使用密码模式需要配置    ==== 配置认证管理器以及用户信息业务实现
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /*endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                //配置令牌存储策略
                .tokenStore(tokenStore)
        .accessTokenConverter(jwtAccessTokenConverter);*/  //该配置是  jwt模式产生  token
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        // 配置jwt内容增强器--上面是非增强器的配置
        delegates.add(jwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(delegates);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                // 配置令牌存储策略
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(tokenEnhancerChain);
    }

    /**
     * @Description: 配置客户端
     * 
     **/
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 配置  client_id   客户端账户
                .withClient("android")
                // 配置  client_secret  客户端密码
                .secret(passwordEncoder.encode("android"))
                // 配置访问token的有效期
                .accessTokenValiditySeconds(3600)
                // 配置刷新token的有效期
                .refreshTokenValiditySeconds(864000)
                // 配置redirect_uri,用于授权成功后的跳转
                // .redirectUris("http://www.baidu.com")
                // 单点登录时配置
                .redirectUris("http://localhost:9501/login")
                // 自动授权配置
                .autoApprove(true)
                // 配置申请的权限范围  作用域
                .scopes("all")
                .authorizedGrantTypes("authorization_code", "password");
                // 配置grant_type,表示授权类型
//                .authorizedGrantTypes("authorization_code", "password", "refresh_token");
    }
/**
 * @Description: //配置认证规则，那些需要认证那些不需要
 * 
 **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        // 获取密钥需要身份认证，使用单点登录时必须配置
//        security.tokenKeyAccess("isAuthenticated()");

        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

}
