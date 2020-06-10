package dao;

import entity.Bill;
import entity.Provider;

import java.sql.SQLException;
import java.util.List;

public interface BillDao {
    public List<Bill> getAllBills() throws SQLException, ClassNotFoundException;

    public int delBill(int id) throws SQLException, ClassNotFoundException;

    public int updateBill(Bill bill) throws SQLException, ClassNotFoundException;

    public int addBill(Bill bill) throws SQLException, ClassNotFoundException;

    public Bill getBillById(int id) throws SQLException, ClassNotFoundException;
}
