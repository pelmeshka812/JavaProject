package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    String html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            " <meta charset=\"UTF-8\">\n" +
            " <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +

            "<form action=\"login\" method=\"post\">\n" +
            " <h2>Login:</h2>\n" +
            " <input placeholder=\"login\" type=\"text\" name=\"login\">\n" +
            " <h2>Password:</h2>\n" +
            " <input type=\"password\" name=\"password\">\n" +
            "<input name='remember' type='checkbox' value='1'>"+

            "<p><input type=\"submit\" value=\"send\"></p>" +
            "</form>\n" +
            "</body>\n" +
            "</html>";
    String admPassword = "password";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (password.equals(admPassword)){
            session.setAttribute("login", login);
            Cookie ck=new Cookie("login", login);
            Cookie ck1 = new Cookie("password", password);
            resp.addCookie(ck);
            resp.addCookie(ck1);
            resp.sendRedirect("/mysuperproject_war_exploded/name");
        } else { resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print( html );
    }
}
