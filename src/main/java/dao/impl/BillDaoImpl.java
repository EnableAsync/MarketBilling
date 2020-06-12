package dao.impl;

import dao.BaseDao;
import dao.BillDao;
import entity.Bill;

import java.sql.*;
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

    @Override
    public int delBill(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "delete from market_billing.bills where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Override
    public int updateBill(Bill bill) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "update market_billing.bills set product_name = ?, product_desc = ?, product_count = ?,total_price = ?, is_payment = ?, provider_id = ?, creator = ?, create_time = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, bill.getProduct_name());
        ps.setString(2, bill.getProduct_desc());
        ps.setInt(3, bill.getProduct_count());
        ps.setBigDecimal(4, bill.getTotal_price());
        ps.setShort(5, bill.getIs_payment());
        ps.setInt(6, bill.getProvider_id());
        ps.setString(7, bill.getCreator());
        ps.setDate(8, new Date(bill.getCreate_time().getTime()));
        ps.setInt(9, bill.getId());
        return ps.executeUpdate();
    }

    @Override
    public int addBill(Bill bill) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "insert into market_billing.bills(product_name, product_desc, product_count, total_price, is_payment, provider_id, creator, create_time) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, bill.getProduct_name());
        ps.setString(2, bill.getProduct_desc());
        ps.setInt(3, bill.getProduct_count());
        ps.setBigDecimal(4, bill.getTotal_price());
        ps.setShort(5, bill.getIs_payment());
        ps.setInt(6, bill.getProvider_id());
        ps.setString(7, bill.getCreator());
        ps.setDate(8, new Date(bill.getCreate_time().getTime()));

        return ps.executeUpdate();
    }

    @Override
    public Bill getBillById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.bills where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();
        return Bill.builder()
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
    }

    @Override
    public List<Bill> getBillsByNameAndPayment(String name, short payment) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.bills where product_name = ? and is_payment = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setShort(2, payment);
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
