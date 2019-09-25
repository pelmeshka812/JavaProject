package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    String html2 = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Login: </h1>";
    String html3 = "<form  action=\"hello\" method=\"get\">\n" +
            "<p><input type=\"submit\" value=\"logout\"></p>" +
            "</form>\n" +
            "</body>\n" +
            "</html>";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if(req.getSession().getAttribute("login") != null){
            out.print(html2 + req.getSession().getAttribute("login")+html3);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login1 = req.getParameter("login");
        doGet(req, resp);
    }
}
