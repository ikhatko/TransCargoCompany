package controller.Servlet.Servlets.Cargo;

import org.hibernate.SessionFactory;
import services.Cargo.SetCargoesToOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/CargoesToOrder")
public class CargoesToOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        int[] addedCargoes = Arrays.stream(req.getParameterValues("addedCargoes")).mapToInt(Integer::parseInt).toArray();
        int id = Integer.parseInt(req.getParameter("id"));
        SetCargoesToOrder.setCargoesToOrder(addedCargoes, id, sessionFactory);
        resp.sendRedirect("/Order");
    }
}
