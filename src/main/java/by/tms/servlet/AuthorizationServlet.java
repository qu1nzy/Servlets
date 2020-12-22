package by.tms.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {
    private final InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User bylogin = inMemoryStorage.getByLogin(login);
        if (bylogin != null) {
            if (bylogin.getPassword().equals(password)) {
                req.getSession().setAttribute("user", bylogin);
            }else {
                resp.getWriter().println("neverni password!!");
            }
        }else{
            resp.getWriter().println("net takogo logina");
        }
    }
}
