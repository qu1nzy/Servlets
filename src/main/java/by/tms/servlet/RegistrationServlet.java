package by.tms.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
private final InMemoryStorage inMemoryStorage =new InMemoryStorage();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name=req.getParameter("name");
    String login=req.getParameter("login");
    String password=req.getParameter("password");
    User user = new User(name,login,password);
    if (inMemoryStorage.getByLogin(login).equals(login))
    {
        resp.getWriter().println("Tako login uge suwestvuet!");
    }
    else {
        inMemoryStorage.addUser(user);
    }
}

}
