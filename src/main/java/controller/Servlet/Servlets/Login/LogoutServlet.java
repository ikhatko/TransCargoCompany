package controller.Servlet.Servlets.Login;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    logger.info("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }
        HttpSession session = req.getSession(false);
        if (session != null) {
            logger.info("User:" + session.getAttribute("User"));
            logger.info("SessionId:" + session.getId() + " invalidated!");
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}
