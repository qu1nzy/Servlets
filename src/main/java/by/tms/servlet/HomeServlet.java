package by.tms.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user=(User) req.getSession().getAttribute("user");
        if (user!=null){
            resp.getWriter().println("Hello"+user.getName());
        }else {
            resp.getWriter().println("Hello Guest");
        }
    }
}
