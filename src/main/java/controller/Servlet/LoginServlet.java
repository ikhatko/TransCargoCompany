package controller.Servlet;

import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1917284334926331040L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        SessionFactory sessionFactory = (SessionFactory) req.getServletContext().getAttribute("SessionFactory");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String errorMsg = null;
        if (email == null || email.equals("")) {
            errorMsg = "User email can't be empty";
        }
        if (password == null || password.equals("")) {
            errorMsg = "User password can't be empty";
        }

        if (errorMsg != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
            out.println("<font color=red>" + errorMsg + "</font>");
            requestDispatcher.include(req, resp);
        }
//        if  password check is true
         /*TODO: check email & password -> connect to data base via hibernate
         * Get user, initialize, add user to session
         * */

//        resp.sendRedirect("WEB-INF/startpage.jsp");
////        if false
//        out.println("<font color=\"red\">ERORR</font>");
//        RequestDispatcher rd = req.getRequestDispatcher("login.html");
//        rd.include(req, resp);
    }
}
