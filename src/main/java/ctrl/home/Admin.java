package ctrl.home;

import dao.BillDao;
import dao.ProviderDao;
import dao.UserDao;
import dao.impl.BillDaoImpl;
import dao.impl.ProviderDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Provider;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

            List<Provider> providerList = providerDao.getAllproviders();
            Map<Integer, String> providerMap =
                    providerList.stream().collect(Collectors.toMap(Provider::getId, Provider::getName));

            session.setAttribute("providers", providerList);
            session.setAttribute("providersMap", providerMap);
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
