package swa.manage.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jinyan on 7/3/17.
 */
public class PrevillegeFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(PrevillegeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.debug("this is MyFilter,url :{}", request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.debug("this is MyFilter,response :{}", servletResponse);

    }

    @Override
    public void destroy() {

    }
}
