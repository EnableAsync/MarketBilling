package dao.impl;

import dao.BaseDao;
import dao.ProviderDao;
import entity.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl extends BaseDao implements ProviderDao {
    public static void main(String[] args) {
        ProviderDao providerDao = new ProviderDaoImpl();
        try {
//            for (Provider p : providerDao.getAllproviders()) {
//                System.out.println(p);
//                providerDao.addProvider(p);
//            }
//            for (Provider p : providerDao.getAllproviders()) {
//                System.out.println(p);
//                providerDao.addProvider(p);
//            }
            providerDao.delProvider(2);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Provider> getAllproviders() throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.providers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Provider> providerList = new ArrayList<>();

        while (rs.next()) {
            Provider provider = Provider.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .tel(rs.getString("tel"))
                    .address(rs.getString("address"))
                    .creator(rs.getString("creator"))
                    .create_time(rs.getDate("create_time"))
                    .build();
            providerList.add(provider);
        }
        return providerList;
    }

    @Override
    public int delProvider(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "delete from market_billing.providers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Override
    public int addProvider(Provider provider) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "insert into market_billing.providers(name, `desc`, tel, address, creator, create_time) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, provider.getName());
        ps.setString(2, provider.getDesc());
        ps.setString(3, provider.getTel());
        ps.setString(4, provider.getAddress());
        ps.setString(5, provider.getCreator());
        ps.setDate(6, (Date) provider.getCreate_time());

        return ps.executeUpdate();
    }

    @Override
    public int updateProvider(Provider provider) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "update market_billing.providers set name = ?, `desc` = ?, tel = ?, creator = ?, address = ?, create_time = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, provider.getName());
        ps.setString(2, provider.getDesc());
        ps.setString(3, provider.getTel());
        ps.setString(4, provider.getAddress());
        ps.setString(5, provider.getCreator());
        ps.setDate(6, (Date) provider.getCreate_time());
        ps.setInt(7, provider.getId());
        return ps.executeUpdate();
    }
}
