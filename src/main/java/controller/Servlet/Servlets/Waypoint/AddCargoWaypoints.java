package controller.Servlet.Servlets.Waypoint;

import org.hibernate.SessionFactory;
import services.Cargo.AddTwoCargoWaypoints;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add cargo waypoints.
 */
@WebServlet("/AddCargoWaypoints")
public class AddCargoWaypoints extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String name = req.getParameter("name");
        String loadFrom = req.getParameter("loadFrom");
        String unloadTo = req.getParameter("unloadTo");
        String weight = req.getParameter("weight");
        String volume = req.getParameter("volume");
        AddTwoCargoWaypoints.addCargoWaypoints(name, weight, volume, loadFrom, unloadTo, sessionFactory);
        resp.sendRedirect("/Cargo");
    }
}
