package com.example2.demo1.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServiceConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    RedisConnectionFactory redisConnectionFactory;
    @Resource
    UserDetailsService userDetailsService;
    /*
        配置授权服务器
     */
    /*
    配置认证客户端
     */

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        String clientId = "client_id";
        String clientSecret = "123";

        clients.inMemory()
                //配置client_id
                .withClient(clientId)
                //授权同意的类型
                .authorizedGrantTypes("password", "refresh_token")
                //有效时间
                .accessTokenValiditySeconds(1800000)
                //配置刷新token的有效期
                .refreshTokenValiditySeconds(60 * 60 * 2 )
                .resourceIds("rid")
                //作用域，范围
                .scopes("all")
                //密码
                .secret(new BCryptPasswordEncoder().encode(clientSecret));

    }
    /**
     * 自定义授权服务配置
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
                //身份验证管理
                //默认除密码模式外，所有授权模式均支持，密码模式需要显示注入authenticationManager开启
                .authenticationManager(authenticationManager)
                //自定义用户密码加载服务
                .userDetailsService(userDetailsService);
    }
    /*
    自定义授权令牌端点的安全约束
    */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许客户端访问 /oauth/check_token 检查 token
        security.checkTokenAccess("isAuthenticated()");
        //允许客户端表单身份验证
        security.allowFormAuthenticationForClients();
    }

}
