package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletName extends HttpServlet {
    String html4 = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>You successfully log in!!! </h1>";
    String html5= "<form  action=\"logout\" method=\"get\">\n" +
            "<p><input type=\"submit\" value=\"logout\"></p>" +
            "</form>\n" +
            "</body>\n" +
            "</html>";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("login") != null) {
            out.print(html4 + request.getSession().getAttribute("login") + html5);
        }

    }
}
