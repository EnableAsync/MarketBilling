package dao.impl;

import dao.BaseDao;
import dao.BillDao;
import entity.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl extends BaseDao implements BillDao {
    public static void main(String[] args) {
        BillDao billDao = new BillDaoImpl();
        try {
            for (Bill b : billDao.getAllBills()) {
                System.out.println(b);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bill> getAllBills() throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.bills";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Bill> billList = new ArrayList<>();

        while (rs.next()) {
            Bill bill = Bill.builder()
                    .id(rs.getInt("id"))
                    .product_name(rs.getString("product_name"))
                    .product_desc(rs.getString("product_desc"))
                    .product_count(rs.getInt("product_count"))
                    .total_price(rs.getBigDecimal("total_price"))
                    .is_payment(rs.getShort("is_payment"))
                    .provider_id(rs.getInt("provider_id"))
                    .creator(rs.getString("creator"))
                    .create_time(rs.getDate("create_time"))
                    .build();
            billList.add(bill);
        }
        return billList;
    }
}
