package controller.Servlet.Servlets.Cargo;

import org.hibernate.SessionFactory;
import services.Cargo.AddNewCargo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add new cargo servlet.
 */
@WebServlet("/AddNewCargo")
public class AddNewCargoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String name = req.getParameter("name");
        String weight = req.getParameter("weight");
        String volume = req.getParameter("volume");
        if (AddNewCargo.addNewCargo(name, weight,
                volume, sessionFactory)) {
            req.getSession().setAttribute("errorMsg",
                    "<div class=\"alert alert-success\">\n <a href=\"#\" "
                            + "class=\"close\" data-dismiss=\"alert\""
                            + " aria-label=\"close\">&times;</a>\n"
                            + "  <strong>Success!</strong> New cargo added.\n"
                            + "</div>");
            resp.sendRedirect("/Cargo");
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/Cargo");
            req.setAttribute("errorMsg", "<div class=\"alert alert-success\">\n"
                    + "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" "
                    + "aria-label=\"close\">&times;</a>\n"
                    + "  <strong>Error!</strong> New cargo not added.\n"
                    + "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
