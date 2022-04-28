package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.service.UserService;
import mvc.service.impl.UserServiceImpl;

/**
 * <p>
 * [首頁]
 * </p>
 * 
 * <pre>
 * -TODO
 * </pre>
 * 
 * @author ken
 * @since 2022/04/18
 */
@WebServlet(urlPatterns = "/servlet/k_user")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 5801698367417878054L;
    private UserService userService;
    {

        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", "KEN Web");
        req.setAttribute("userList", userService.query());
        req.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(req, resp);
    }
}
