package controller.Servlet.Filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Authentication filter.
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private Logger logger = Logger.getLogger(AuthenticationFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        logger.info("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);

        if (session == null && !(uri.endsWith("login.jsp") || uri.endsWith("/Login"))) {
            logger.info("Unauthorized access request");
            res.sendRedirect("/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
