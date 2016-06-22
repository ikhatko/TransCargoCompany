package controller.Servlet.Servlets.Driver;

import model.Entities.Order;
import model.Entities.Waypoint;
import org.hibernate.SessionFactory;
import services.Order.GetOrderByDriverId;
import services.Order.SetWeightAndVolume;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Current order.
 */
@WebServlet("/CurrentOrder")
public class CurrentOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String driverId = req.getParameter("driverId");
        Order order = GetOrderByDriverId.getOrderByDriverId(driverId, sessionFactory);
        //TODO: draw route on google map
        req.setAttribute("order", order);
        req.setAttribute("id", driverId);

        req.getRequestDispatcher("driver/order.jsp").include(req, resp);
    }
}
