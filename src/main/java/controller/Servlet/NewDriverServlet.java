package controller.Servlet;

import org.hibernate.SessionFactory;
import services.AddNewDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddNewDriver")
public class NewDriverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        if (AddNewDriver.addNewDriver(firstName, lastName, sessionFactory)) {
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> New driver added.\n" +
                    "</div>");
            resp.sendRedirect("/Driver");
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Driver");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Error!</strong> New driver not added.\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
