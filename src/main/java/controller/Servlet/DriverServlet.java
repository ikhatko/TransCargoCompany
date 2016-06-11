package controller.Servlet;

import model.Entities.Driver;
import org.hibernate.SessionFactory;
import services.GetAllDrivers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Driver")
public class DriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");
        List<Driver> allDrivers = GetAllDrivers.getAllDrivers(sessionFactory);
        req.setAttribute("resultList", allDrivers);
        req.getRequestDispatcher("driver.jsp").include(req, resp);
    }
}
