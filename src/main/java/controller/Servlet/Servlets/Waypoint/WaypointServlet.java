package controller.Servlet.Servlets.Waypoint;

import model.Entities.User;
import model.Entities.Waypoint;
import org.hibernate.SessionFactory;
import services.Waypoint.GetAllWaypoints;
import services.Waypoint.RemoveWaypoint;
import services.Waypoint.UpdateWaypoint;
import utils.servlet.CheckUserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Waypoint servlet.
 */
@WebServlet("/Waypoint")
public class WaypointServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        List<Waypoint> allWaypoints =
                GetAllWaypoints.getAllWaypoints(sessionFactory);
        req.setAttribute("resultList", allWaypoints);
        User user = (User) req.getSession().getAttribute("user");
        String userRole = CheckUserRole.getUserRole(user);
        if (!userRole.equals("public")) {
            req.getRequestDispatcher(userRole + "/waypoint.jsp").include(req, resp);
        } else {
            resp.sendRedirect("public/index.jsp");
        }

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
                RemoveWaypoint.removeWaypoint(id, sessionFactory);
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
            String id = req.getParameter("id");
            String cargoId = req.getParameter("cargoId");
            String waypointType = req.getParameter("waypointType");
            String city = req.getParameter("city");
            String order = req.getParameter("order");

            UpdateWaypoint.updateWaypoint(Integer.parseInt(id), cargoId,
                    waypointType, city, order, sessionFactory);
            doGet(req, resp);
        }
    }
}
