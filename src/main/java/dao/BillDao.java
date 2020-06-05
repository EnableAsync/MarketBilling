package dao;

import entity.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillDao {
    public List<Bill> getAllBills() throws SQLException, ClassNotFoundException;
}
