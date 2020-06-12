package ctrl.provider;

import dao.ProviderDao;
import dao.UserDao;
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

        ProviderDao providerDao = new ProviderDaoImpl();
        try {
            List<Provider> providers = providerDao.getProvidersByNameAndDesc(
                    req.getParameter("name"),
                    req.getParameter("desc")
            );
            req.setAttribute("providers", providers);

            req.getRequestDispatcher("provider_result.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
