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

public class Add extends HttpServlet {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
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
            userDao.addUser(
                    User.builder()
                    .username(username)
                    .password(password)
                    .phone(phone)
                    .address(address)
                    .birthday(birthday)
                    .role(role)
                    .build()
            );

            session.setAttribute("users", userDao.getAllUsers());
            resp.sendRedirect("user_list.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
