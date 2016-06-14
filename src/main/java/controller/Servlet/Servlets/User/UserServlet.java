package controller.Servlet.Servlets.User;

import model.Entities.User;
import org.hibernate.SessionFactory;
import services.User.GetAllUsers;
import services.User.RemoveUser;
import services.User.UpdateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type User servlet.
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        List<User> allUsers = GetAllUsers.getAllUsers(sessionFactory);
        req.setAttribute("resultList", allUsers);
        req.getRequestDispatcher("user.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String delete = req.getParameter("delete");
        if (delete != null) {
            try {
                int id = Integer.parseInt(delete);
                RemoveUser.removeUser(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg",
                        "<div class=\"alert alert-warning\">\n"
                                + "  <a href=\"#\" class=\"close\" "
                                + "data-dismiss=\"alert\""
                                + " aria-label=\"close\">&times;</a>\n"
                                + "<strong>Warning!</strong> Wrong id!\n"
                                + "</div>");
            }
        } else {
            Integer id = Integer.valueOf(req.getParameter("id"));
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String userRoleId = req.getParameter("userRole");
            UpdateUser.updateUser(id, firstName, lastName, email,
                    password, userRoleId, sessionFactory);
            doGet(req, resp);
        }
    }
}
