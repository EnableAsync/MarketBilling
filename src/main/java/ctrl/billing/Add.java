package ctrl.billing;

import dao.BillDao;
import dao.impl.BillDaoImpl;
import entity.Bill;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

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
            billDao.addBill(Bill.builder()
                    .product_name(name)
                    .product_desc(desc)
                    .product_count(count)
                    .total_price(total)
                    .is_payment(isPay)
                    .provider_id(provider_id)
                    .creator(creator)
                    .create_time(time)
                    .build());

            req.getSession().setAttribute("bills", billDao.getAllBills());
            resp.sendRedirect("bill_list.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
