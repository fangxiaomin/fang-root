package com.fang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:  自定义的过滤器类型。
 *      PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
         * ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务。
         * POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
         * ERROR：在其他阶段发生错误时执行该过滤器。
 * @projectName:fang-root
 * @see:com.fang.gateway.filter
 * @author:fxm
 * @createTime:2021/7/6 17:02
 * @version:1.0
 */
@Slf4j
@Component
public class OwnZuulFilter extends ZuulFilter {

    /**
     * 过滤器类型，有pre、routing、post、error四种。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，数值越小优先级越高。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否进行过滤，返回true会执行过滤。
     * 断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效
     *      * 实际运用中我们可以利用该方法来指定过滤器的有效范围
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String remoteHost = request.getRemoteHost();
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        log.info("Remote host:{},method:{},uri:{}", remoteHost, method, requestURI);

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is empty");
        }
        return null;
    }
}
