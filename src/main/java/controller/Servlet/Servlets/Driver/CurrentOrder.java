package controller.Servlet.Servlets.Driver;

import model.Entities.User;
import model.Entities.Waypoint;
import org.hibernate.SessionFactory;
import services.Order.GetOrderWaypoints;
import utils.servlet.CheckUserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CurrentOrder")
public class CurrentOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        List<Waypoint> orderWaypoints = GetOrderWaypoints.getOrderWaypoints("5", sessionFactory);
        req.setAttribute("waypoints", orderWaypoints);
        User user = (User) req.getSession().getAttribute("user");
        String userRole = CheckUserRole.getUserRole(user);
        if (!userRole.equals("public")) {
            req.getRequestDispatcher(userRole + "/order.jsp").include(req, resp);
        } else {
            resp.sendRedirect("public/index.jsp");
        }
    }
}
