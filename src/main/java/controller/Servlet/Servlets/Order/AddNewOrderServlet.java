package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddNewOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddNewOrder")
public class AddNewOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String orderStatus = req.getParameter("orderStatus");

        if (AddNewOrder.addNewOrder(orderStatus, sessionFactory)) {
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Success!</strong> New order added.\n" +
                    "</div>");
            resp.sendRedirect("/Order");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Order");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n" +
                    "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                    "  <strong>Error!</strong> New order not added.\n" +
                    "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
