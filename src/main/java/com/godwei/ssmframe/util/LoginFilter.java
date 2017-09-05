package com.godwei.ssmframe.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xin.zhang
 *
 * 用于登录拦截和编码设置
 */
public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        if (noLoginPaths != null) {
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i] == null || "".equals(strArray[i])) continue;
                if (request.getRequestURI().contains(strArray[i])) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }

        }


        if (session.getAttribute("user") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
