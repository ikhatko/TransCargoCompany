package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddDriverToOrder;
import services.Order.AddWagonToOrder;
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
        String[] orderDrivers = req.getParameterValues("orderDriver");
        String id = req.getParameter("id");
        if (id != null && orderDrivers != null) {
            AddDriverToOrder.addDriverToOrder(orderDrivers, id, sessionFactory);
        }
        resp.sendRedirect("/Order");
    }
}
