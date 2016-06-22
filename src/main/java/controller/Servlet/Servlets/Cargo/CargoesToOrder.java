package controller.Servlet.Servlets.Cargo;

import org.hibernate.SessionFactory;
import services.Cargo.SetCargoesToOrder;
import services.Order.SetWeightAndVolume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * The type Cargoes to order.
 */
@WebServlet("/CargoesToOrder")
public class CargoesToOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String[] addedCargoes1 = req.getParameterValues("addedCargoes");
        String cargoId = req.getParameter("id");

        if (cargoId != null && addedCargoes1 != null) {
            int[] addedCargoes =
                    Arrays.stream(addedCargoes1).mapToInt(Integer::parseInt).toArray();
            int id = Integer.parseInt(cargoId);
            SetCargoesToOrder.setCargoesToOrder(addedCargoes,
                    id, sessionFactory);
        }
        SetWeightAndVolume setWeightAndVolume = new SetWeightAndVolume();
        setWeightAndVolume.setMaxWeightAndVolume(cargoId, sessionFactory);
        resp.sendRedirect("/Order");
    }
}
