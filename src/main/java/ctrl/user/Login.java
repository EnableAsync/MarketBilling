package ctrl.user;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends HttpServlet {
    /**
     * 只允许使用 POST 方式登录
     *
     * @param req  请求参数
     * @param resp 响应参数
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + "|" + password);
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.getUserByName(username);
            System.out.println(user);
            if (password == null) {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }

            if (!password.equals(user.getPassword())) {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }

            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("admin").forward(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
