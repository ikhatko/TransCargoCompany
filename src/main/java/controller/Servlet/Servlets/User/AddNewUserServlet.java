package controller.Servlet.Servlets.User;

import org.hibernate.SessionFactory;
import services.User.AddNewUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add new user servlet.
 */
@WebServlet("/AddNewUser")
public class AddNewUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int userRoleId = Integer.parseInt(req.getParameter("userRole"));

        if (AddNewUser.addNewUser(firstName, lastName, email, password, userRoleId, sessionFactory)) {
            req.getSession().setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> New user added.\n" +
                    "</div>");
            resp.sendRedirect("/User");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/User");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Error!</strong> New user not added.\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
