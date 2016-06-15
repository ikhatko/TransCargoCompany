package controller.Servlet.Servlets.Login;

import model.Entities.User;
import model.Entities.UserRole;
import org.hibernate.SessionFactory;
import services.User.CheckLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Login servlet.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = CheckLogin.checkEmailAndPassword(email,
                password, sessionFactory);
        int userRoleId = 4;
        if (user != null) {
            UserRole userRole = user.getUserRole();
            userRoleId = userRole.getUserRoleId();
        }
        if (userRoleId == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/admin/index.jsp");
        } else if (userRoleId == 2) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/staff/staff.jsp");
        } else if (userRoleId == 3) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/driver/driver.jsp");
        } else if (userRoleId == 4) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/public/public.jsp");
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("login.jsp");
            req.setAttribute("errorMsg",
                    "<div class=\"alert alert-warning\">\n"
                            + "  <a href=\"#\" class=\"close\" "
                            + "data-dismiss=\"alert\""
                            + " aria-label=\"close\">&times;</a>\n"
                            + "  <strong>Warning!</strong> "
                            + "Wrong email or password.\n"
                            + "</div>");
            requestDispatcher.include(req, resp);
        }
    }
}

