package controller.Servlet.Servlets.Wagon;

import org.hibernate.SessionFactory;
import services.Wagon.AddNewWagon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add new wagon servlet.
 */
@WebServlet("/AddNewWagon")
public class AddNewWagonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String licensePlate = req.getParameter("licensePlate");
        String driversChange = req.getParameter("driversChange");
        String maxWeight = req.getParameter("maxWeight");
        String maxVolume = req.getParameter("maxVolume");

        if (AddNewWagon.addNewWagon(licensePlate, driversChange, maxWeight, maxVolume, sessionFactory)) {
            req.getSession().setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> New wagon added.\n" +
                    "</div>");
            resp.sendRedirect("/Wagon");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Wagon");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Error!</strong> New wagon not added.\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
