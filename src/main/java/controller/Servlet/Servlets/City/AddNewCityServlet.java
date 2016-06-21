package controller.Servlet.Servlets.City;

import org.hibernate.SessionFactory;
import services.City.AddNewCity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Add new city servlet.
 */
@WebServlet("/AddNewCity")
public class AddNewCityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory)
                req.getServletContext().getAttribute("SessionFactory");
        String cityName = req.getParameter("cityName");
        if (AddNewCity.addNewCity(cityName, sessionFactory)) {
            req.getSession().setAttribute("errorMsg",
                    "<div class=\"alert alert-success\">\n"
                            + "  <a href=\"#\" class=\"close\" "
                            + "data-dismiss=\"alert\" "
                            + "aria-label=\"close\">&times;</a>\n"
                            + "  <strong>Success!</strong> New city added.\n"
                            + "</div>");
            resp.sendRedirect("/City");
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/City");
            req.setAttribute("errorMsg",
                    "<div class=\"alert alert-success\">\n"
                            + "  <a href=\"#\" class=\"close\" "
                            + "data-dismiss=\"alert\" "
                            + "aria-label=\"close\">&times;</a>\n"
                            + "  <strong>Error!</strong> New city not added.\n"
                            + "</div>");
            requestDispatcher.include(req, resp);
        }

    }
}
