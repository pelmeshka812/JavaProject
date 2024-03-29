package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogOut")
public class ServletLogOut extends HttpServlet {
    String html ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            " <meta charset=\"UTF-8\">\n" +
            " <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<form action=\"login\" method=\"get\">\n" +
            "<p><input type=\"submit\" value=\"Log in\"></p>" +
            "</form>\n" +
            "</body>\n" +
            "</html>";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        Cookie[] cr = request.getCookies();
        for (Cookie cook: cr) {
            if  (cook.getName().equals("login")){
                cook.setMaxAge(0);
                response.addCookie(cook);
            }
            if (cook.getName().equals("password")){
                cook.setMaxAge(0);
                response.addCookie(cook);
            }

        }
        PrintWriter out = response.getWriter();
        out.print( html );
    }
}
