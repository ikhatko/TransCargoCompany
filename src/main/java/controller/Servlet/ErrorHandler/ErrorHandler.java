package controller.Servlet.ErrorHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The type Error handler.
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {

    /**
     * The constant ERROR_CODE.
     */
    public static final int ERROR_CODE = 500;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        catchError(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        catchError(req, resp);
    }

    private void catchError(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Throwable throwable =
                (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode =
                (Integer) req.getAttribute("javax.servlet.error.status_code");
        String requestUri =
                (String) req.getAttribute("javax.servlet.error.request_uri");
        String servletName =
                (String) req.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><head><title>Exception/Error Details"
                + "</title></head><body>");
        if (statusCode != ERROR_CODE) {
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
            out.write("<strong>Requested URI</strong>:" + requestUri);
        } else {
            out.write("<h3>Exception Details</h3>");
            out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
            out.write("<ul><li>Servlet Name:" + servletName + "</li>");
            out.write("<li>Exception Name:"
                    + throwable.getClass().getName() + "</li>");
            out.write("<li>Requested URI:"
                    + requestUri + "</li>");
            out.write("<li>Exception Message:"
                    + throwable.getMessage() + "</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");
        out.write("<a href=\"/login.jsp\">Login Page</a>");
        out.write("</body></html>");
    }
}
