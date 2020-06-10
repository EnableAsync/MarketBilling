package ctrl.provider;

import dao.ProviderDao;
import dao.impl.ProviderDaoImpl;
import entity.Provider;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Modify extends HttpServlet {
    /**
     * 根据 Id 获取 Provider 信息
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProviderDao providerDao = new ProviderDaoImpl();
        try {
            Provider p = providerDao.getProviderById(id);
            if (p == null) {
                return;
            }
            req.setAttribute("provider", p);
            req.getRequestDispatcher("provider_modify.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改 Provider 信息
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
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        String creator = ((User) req.getSession().getAttribute("user")).getUsername();
        Date time = new Date();

        ProviderDao providerDao = new ProviderDaoImpl();
        try {
            Provider p = entity.Provider.builder()
                    .id(id)
                    .name(name)
                    .desc(desc)
                    .tel(tel)
                    .address(address)
                    .creator(creator)
                    .create_time(time)
                    .build();
            providerDao.updateProvider(p);

            List<Provider> providerList = providerDao.getAllproviders();
            Map<Integer, String> providerMap =
                    providerList.stream().collect(Collectors.toMap(Provider::getId, Provider::getName));

            session.setAttribute("providers", providerList);
            session.setAttribute("providersMap", providerMap);
            resp.sendRedirect("provider_list.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
