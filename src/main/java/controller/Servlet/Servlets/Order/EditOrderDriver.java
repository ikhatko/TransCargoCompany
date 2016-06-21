package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddDriverToOrder;
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
        String orderDriver = req.getParameter("orderDriver");
        String id = req.getParameter("id");
        if (id != null && orderDriver != null) {
            AddDriverToOrder.addDriverToOrder(orderDriver, id, sessionFactory);
        }
        resp.sendRedirect("/Order");
    }
}
