package ctrl.billing;

import dao.BillDao;
import dao.ProviderDao;
import dao.impl.BillDaoImpl;
import dao.impl.ProviderDaoImpl;
import entity.Bill;
import entity.Provider;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Modify extends HttpServlet {
    /**
     * 修改 Bill
     */
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
        int count = Integer.parseInt(req.getParameter("count"));
        BigDecimal total = new BigDecimal(req.getParameter("total"));
        short isPay = Short.parseShort(req.getParameter("isPay"));
        int provider_id = Integer.parseInt(req.getParameter("provider_id"));
        String creator = ((User) req.getSession().getAttribute("user")).getUsername();
        Date time = new Date();

        BillDao billDao = new BillDaoImpl();
        try {
            Bill bill = Bill.builder()
                    .id(id)
                    .product_name(name)
                    .product_desc(desc)
                    .product_count(count)
                    .total_price(total)
                    .is_payment(isPay)
                    .provider_id(provider_id)
                    .creator(creator)
                    .create_time(time)
                    .build();
            billDao.updateBill(bill);

            req.getSession().setAttribute("bills", billDao.getAllBills());
            resp.sendRedirect("bill_list.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 Id 获取 Bill
     */
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
        BillDao billDao = new BillDaoImpl();
        try {
            Bill bill = billDao.getBillById(id);
            if (bill == null) {
                return;
            }
            req.setAttribute("bill", bill);
            req.getRequestDispatcher("bill_modify.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
