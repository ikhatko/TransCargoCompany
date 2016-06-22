package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddNewOrder;
import services.Order.UpdateRoute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add new order servlet.
 */
@WebServlet("/UpdateRoute")
public class UpdateRouteData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String orderId = req.getParameter("id");
        UpdateRoute.updateRoute(orderId, sessionFactory);
        resp.sendRedirect("/Order");
    }
}
