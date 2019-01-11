package daos;

import daos.entity.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("ALL")
public class DBStoreDAO implements DAO<Store> {


    @Override
    public void add(Store store) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        AtomicReference<String> sql = new AtomicReference<>("INSERT INTO dbo.STORE (StoreID, StoreName) VALUES (?, ?);");
        try {
            preparedStatement = connection.prepareStatement(sql.get());

            preparedStatement.setLong(1, store.getStoreID());
            preparedStatement.setString(2, store.getStoreName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Store> getAll() {
        List<Store> storeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT [StoreID], [StoreName] FROM [sq].[dbo].[STORE];";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Store store = new Store();
                store.setStoreID(resultSet.getLong("StoreID"));
                store.setStoreName(resultSet.getString("StoreName"));

                storeList.add(store);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return  storeList;
    }

    @Override
    public Store get(Store store_) {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT [StoreID], [StoreName] FROM [sq].[dbo].[STORE] WHERE StoreID="+Long.toString(store_.getStoreID())+"";
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    Store store = new Store();
                    store.setStoreID(resultSet.getLong("StoreID"));
                    store.setStoreName(resultSet.getString("StoreName"));
                }
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                if (statement != null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return store_;
    }



    @Override
    public void update(Store store) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE [dbo].[STORE] SET [StoreName]=? WHERE [StoreID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, store.getStoreName());
            preparedStatement.setLong(2,store.getStoreID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null ){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void remove(Store store) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM [dbo].[STORE] WHERE [StoreID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, store.getStoreID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
