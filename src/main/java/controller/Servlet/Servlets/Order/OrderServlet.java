package controller.Servlet.Servlets.Order;

import model.Entities.Order;
import org.hibernate.SessionFactory;
import services.Order.GetAllOrders;
import services.Order.RemoveOrder;
import services.Order.UpdateOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Order servlet.
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        List<Order> allOrders = GetAllOrders.getAllOrders(sessionFactory);
        req.setAttribute("resultList", allOrders);
        req.getRequestDispatcher("order.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String delete = req.getParameter("delete");
        if (delete != null) {
            try {
                int id = Integer.parseInt(delete);
                RemoveOrder.removeOrder(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg", "<div class=\"alert alert-warning\">\n" +
                        "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                        "  <strong>Warning!</strong> Wrong deleted id!\n" +
                        "</div>");
            }
        } else {
            Integer id = Integer.valueOf(req.getParameter("id"));
            String orderStatusId = req.getParameter("orderStatusId");
            String orderWagonId = req.getParameter("orderWagonId");
            UpdateOrder.updateOrder(id,orderStatusId,orderWagonId,sessionFactory);
            doGet(req, resp);
        }
    }
}
