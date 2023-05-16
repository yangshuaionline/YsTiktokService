package yang.shuai.ys_tiktok_service.filter;


import org.springframework.core.annotation.Order;
import yang.shuai.ys_tiktok_service.service.PhoneCodeService;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * 监听网站状态
 */
@Order(1)
@WebFilter(filterName = "accountFilter", urlPatterns = "/*")
public class AccountFilter implements Filter {
    @Resource
    PhoneCodeService phoneCodeService;
//    public static Map<String,String> AETICLE_TYPE = new HashMap<>();
    @Override
    public void init(FilterConfig filterConfig){
        phoneCodeService.createTable();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
        phoneCodeService = null;
    }
}
