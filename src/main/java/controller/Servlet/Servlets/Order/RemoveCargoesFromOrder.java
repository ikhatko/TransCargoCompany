package controller.Servlet.Servlets.Order;

import org.hibernate.SessionFactory;
import services.Order.AddDriverToOrder;
import services.Order.CheckDriverHours;
import services.Order.RemoveCargoes;
import services.Order.SetWeightAndVolume;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Remove cargoes from order.
 */
@WebServlet("/RemoveCargoes")
public class RemoveCargoesFromOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String id = req.getParameter("id");
        String[] cargoes = req.getParameterValues("cargoes");
        RemoveCargoes.removeCargoes(id, cargoes, sessionFactory);
        SetWeightAndVolume setWeightAndVolume = new SetWeightAndVolume();
        setWeightAndVolume.setMaxWeightAndVolume(id, sessionFactory);
        resp.sendRedirect("/Cargo");
    }
}
