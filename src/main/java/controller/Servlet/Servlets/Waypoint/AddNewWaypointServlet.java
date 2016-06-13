package controller.Servlet.Servlets.Waypoint;

import org.hibernate.SessionFactory;
import services.Waypoint.AddNewWaypoint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddNewWaypoint")
public class AddNewWaypointServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String cargoId = req.getParameter("cargoId");
        String waypointType = req.getParameter("waypointType");
        String city = req.getParameter("city");

        if (AddNewWaypoint.addNewWaypoint(cargoId, waypointType, city, sessionFactory)) {
            req.getSession().setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> New waypoint added.\n" +
                    "</div>");
            resp.sendRedirect("/Waypoint");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Wagon");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Error!</strong> New waypoint not added.\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
