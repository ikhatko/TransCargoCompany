package controller.Servlet.Servlets.Wagon;

import model.Entities.Wagon;
import org.hibernate.SessionFactory;
import services.Wagon.GetAllWagons;
import services.Wagon.RemoveWagon;
import services.Wagon.UpdateWagon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Wagon")
public class WagonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        List<Wagon> allWagons = GetAllWagons.getAllWagons(sessionFactory);
        req.setAttribute("resultList", allWagons);
        req.getRequestDispatcher("wagon.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        String delete = req.getParameter("delete");
        if (delete != null) {
            try {
                int id = Integer.parseInt(delete);
                RemoveWagon.removeWagon(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg", "<div class=\"alert alert-warning\">\n" +
                        "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
                        "  <strong>Warning!</strong> Wrong deleted id!\n" +
                        "</div>");
            }
        } else {
            String id = req.getParameter("id");
            String licensePlate = req.getParameter("licensePlate");
            int driversChange = Integer.parseInt(req.getParameter("driversChange"));
            float maxWeight = Float.parseFloat(req.getParameter("maxWeight"));
            float maxVolume = Float.parseFloat(req.getParameter("maxVolume"));
            String currentCity = req.getParameter("currentCity");
            String wagonStatus = req.getParameter("wagonStatus");

            UpdateWagon.updateWagon(Integer.parseInt(id), licensePlate, driversChange, maxWeight, maxVolume, currentCity, wagonStatus, sessionFactory);
            doGet(req, resp);
        }
    }
}
