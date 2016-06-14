package controller.Servlet.Servlets.Login;

import org.hibernate.SessionFactory;
import services.User.RegisterNewUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Register servlet.
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("emailReg");
        String password = req.getParameter("passwordReg");

        if (RegisterNewUser.registerNewUser(firstName, lastName, email, password, sessionFactory)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> Registration successfully, you can login!\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            req.setAttribute("errorMsg", "<div class=\"alert alert-warning\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Warning!</strong> User already exist, please login!\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }


    }
}
