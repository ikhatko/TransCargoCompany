package controller.Servlet.Servlets.Cargo;

import model.Entities.Cargo;
import model.Entities.User;
import org.hibernate.SessionFactory;
import services.Cargo.GetAllCargoes;
import services.Cargo.RemoveCargo;
import services.Cargo.UpdateCargo;
import utils.servlet.CheckUserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Cargo servlet.
 */
@WebServlet("/Cargo")
public class CargoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        List<Cargo> allCargo = GetAllCargoes.getAllCargoes(sessionFactory);
        req.setAttribute("resultList", allCargo);
        User user = (User) req.getSession().getAttribute("user");
        String userRole = CheckUserRole.getUserRole(user);
        if (!userRole.equals("public")) {
            req.getRequestDispatcher(userRole + "/cargo.jsp").include(req, resp);
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
                RemoveCargo.removeCargo(id, sessionFactory);
                doGet(req, resp);
            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg",
                        "<div class=\"alert alert-warning\">\n"
                                + " <a href=\"#\" class=\"close\" "
                                + "data-dismiss=\"alert\" "
                                + "aria-label=\"close\">&times;</a>\n"
                                + "<strong>Warning!</strong>Wrong id!\n</div>");
            }
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String weight = req.getParameter("weight");
            String volume = req.getParameter("volume");
            String cargoStatusId = req.getParameter("cargoStatusId");
            UpdateCargo.updateCargo(id, name, weight, volume,
                    cargoStatusId, sessionFactory);
            doGet(req, resp);
        }
    }
}
