package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddDriverToOrder;
import services.Order.CheckDriverHours;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditOrderDriver")
public class EditOrderDriver extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String orderDriverId = req.getParameter("orderDriver");
        String id = req.getParameter("id");

        if (id != null && orderDriverId != null && CheckDriverHours.checkDriverHours(orderDriverId, id, sessionFactory)) {
            if (AddDriverToOrder.addDriverToOrder(orderDriverId, id, sessionFactory)) {
                RequestDispatcher requestDispatcher =
                        req.getRequestDispatcher("/Order");
                req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n"
                        + "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" "
                        + "aria-label=\"close\">&times;</a>\n"
                        + "  <strong>Success!</strong> New driver added ! \n"
                        + "</div>");
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("/Order");
            }
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/Order");
            req.setAttribute("errorMsg", "<div class=\"alert alert-warning\">\n"
                    + "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" "
                    + "aria-label=\"close\">&times;</a>\n"
                    + "  <strong>Error!</strong> New driver doesn't added ! \n"
                    + "</div>");
            requestDispatcher.forward(req, resp);
        }
    }
}
