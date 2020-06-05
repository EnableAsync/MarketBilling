package ctrl.home;

import dao.BillDao;
import dao.ProviderDao;
import dao.UserDao;
import dao.impl.BillDaoImpl;
import dao.impl.ProviderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Admin extends HttpServlet {
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

        User u = (User) o;
        session.setAttribute("user", u);

        UserDao userDao = new UserDaoImpl();
        BillDao billDao = new BillDaoImpl();
        ProviderDao providerDao = new ProviderDaoImpl();
        try {
            session.setAttribute("users", userDao.getAllUsers());
            session.setAttribute("bills", billDao.getAllBills());
            session.setAttribute("providers", providerDao.getAllproviders());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("admin_index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
