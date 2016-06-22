package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddWagonToOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Edit order wagon.
 */
@WebServlet("/EditOrderWagon")
public class EditOrderWagon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String orderWagon = req.getParameter("orderWagon");
        String id = req.getParameter("id");
        if (id != null && orderWagon != null) {
            AddWagonToOrder.addWagon(orderWagon, id, sessionFactory);
        }
        resp.sendRedirect("/Order");
    }
}
