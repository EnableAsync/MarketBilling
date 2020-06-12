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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modify extends HttpServlet {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据 Id 获取 User 信息
     */
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

        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.getUserById(id);
            if (user == null) {
                return;
            }

            req.setAttribute("user", user);
            req.getRequestDispatcher("user_modify.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改 User 信息
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        short role = Short.parseShort(req.getParameter("role"));
        Date birthday = null;
        try {
            birthday = sdf.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDaoImpl();
        try {
            User u = User.builder()
                    .id(id)
                    .username(username)
                    .phone(phone)
                    .address(address)
                    .birthday(birthday)
                    .role(role)
                    .build();
            System.out.println(u);
            userDao.updateUser(
                    u
            );

            session.setAttribute("users", userDao.getAllUsers());
            resp.sendRedirect("user_list.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
