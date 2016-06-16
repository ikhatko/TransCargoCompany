package controller.Servlet.Servlets.Order;

import model.Entities.Cargo;
import model.Entities.Order;
import model.Entities.User;
import org.hibernate.SessionFactory;
import services.Cargo.GetFreeCargoes;
import services.Order.GetAllOrders;
import services.Order.RemoveOrder;
import services.Order.UpdateOrder;
import utils.servlet.CheckUserRole;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        List<Order> allOrders = GetAllOrders.getAllOrders(sessionFactory);
        List<Cargo> cargos = GetFreeCargoes.getFreeCargoes(sessionFactory);

        req.setAttribute("resultList", allOrders);
        req.setAttribute("cargoesList", cargos);

        User user = (User) req.getSession().getAttribute("user");
        String userRole = CheckUserRole.getUserRole(user);
        if (!userRole.equals("public")) {
            req.getRequestDispatcher(userRole + "/order.jsp").include(req, resp);
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
                RemoveOrder.removeOrder(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg",
                        "<div class=\"alert alert-warning\">\n"
                                + "  <a href=\"#\" class=\"close\" "
                                + "data-dismiss=\"alert\""
                                + " aria-label=\"close\">&times;</a>\n"
                                + "<strong>Warning!</strong>Wrong deleted id!\n"
                                + "</div>");
            }
        } else {
            Integer id = Integer.valueOf(req.getParameter("id"));
            String orderStatusId = req.getParameter("orderStatusId");
            String orderWagonId = req.getParameter("orderWagonId");
            UpdateOrder.updateOrder(id, orderStatusId,
                    orderWagonId, sessionFactory);
            doGet(req, resp);
        }
    }
}
