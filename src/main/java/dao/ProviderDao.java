package dao;

import entity.Provider;

import java.sql.SQLException;
import java.util.List;

public interface ProviderDao {
    public List<Provider> getAllproviders() throws SQLException, ClassNotFoundException;

    public int delProvider(int id) throws SQLException, ClassNotFoundException;

    public int updateProvider(Provider provider) throws SQLException, ClassNotFoundException;

    public int addProvider(Provider provider) throws SQLException, ClassNotFoundException;

    public Provider getProviderById(int id) throws SQLException, ClassNotFoundException;

    public List<Provider> getProvidersByNameAndDesc(String name, String desc) throws SQLException, ClassNotFoundException;
}
