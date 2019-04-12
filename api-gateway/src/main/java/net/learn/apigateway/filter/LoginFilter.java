package net.learn.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 登录过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型，前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序越小，越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //System.out.println(request.getRequestURI());
        String requestURI = request.getRequestURI();
        if("/apigateway/order/api/v1/order/save".equalsIgnoreCase(requestURI)){
            return true;
        }
        else if("/apigateway/product/api/v1/product/list".equalsIgnoreCase(requestURI)){
            return true;
        }
        else if("/apigateway/product/api/v1/product/save".equalsIgnoreCase(requestURI)){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext= RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            token=request.getParameter("token");
        }


        else if (StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}
