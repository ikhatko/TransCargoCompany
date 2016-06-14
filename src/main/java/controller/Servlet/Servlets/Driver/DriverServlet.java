package controller.Servlet.Servlets.Driver;

import model.Entities.Driver;
import org.hibernate.SessionFactory;
import services.Driver.GetAllDrivers;
import services.Driver.RemoveDriver;
import services.Driver.UpdateDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Driver servlet.
 */
@WebServlet("/Driver")
public class DriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        List<Driver> allDrivers = GetAllDrivers.getAllDrivers(sessionFactory);
        req.setAttribute("resultList", allDrivers);
        req.getRequestDispatcher("driver.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String delete = req.getParameter("delete");
        if (delete != null) {
            try {
                int id = Integer.parseInt(delete);
                RemoveDriver.removeDriver(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg", "<div class=\"alert alert-warning\">\n" +
                        "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                        "  <strong>Warning!</strong> Wrong deleted id!\n" +
                        "</div>");
            }
        } else {
            String id = req.getParameter("id");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String hours = req.getParameter("hours");
            String cityId = req.getParameter("city");
            String driverStatusId = req.getParameter("driverStatus");
            String wagonId = req.getParameter("wagon");
            String orderId = req.getParameter("orderId");
            UpdateDriver.updateDriver(Integer.parseInt(id), sessionFactory, firstName, lastName, hours, cityId, driverStatusId, wagonId, orderId);
            doGet(req, resp);
        }
    }
}
