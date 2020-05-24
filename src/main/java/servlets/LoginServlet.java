package servlets;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
  private final HashMap<String, Object> data = new HashMap<>();
  private final UserService userService = new UserService();
  private final TemplateEngine engine;

  public LoginServlet(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    data.put("message", "");
    engine.render("login.html", data, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    email = String.join("-", email.split("@"));
    String password = req.getParameter("password");
    if (!userService.containsMail(email)) {
      data.put("message", "User is not found!");
      engine.render("login.html", data, resp);
      return;
    }
    if (!userService.checkPass(email, password)) {
      data.put("message", "Password is not correct!");
      engine.render("login.html", data, resp);
      return;
    }
    int id = userService.getUserID(email);
    Cookie cookie = new Cookie("sign", String.valueOf(id));
    cookie.setMaxAge(6 * 60 * 60);
    resp.addCookie(cookie);
    resp.sendRedirect("/users");
  }
}
