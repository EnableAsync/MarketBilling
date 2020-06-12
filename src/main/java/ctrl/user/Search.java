package ctrl.user;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.getUserByName(req.getParameter("name"));
            req.setAttribute("user", user);

            req.getRequestDispatcher("user_result.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
