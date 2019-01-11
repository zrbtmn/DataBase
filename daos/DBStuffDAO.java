package daos;

import daos.entity.Stuff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("ALL")
public class DBStuffDAO implements DAO<Stuff> {


    @Override
    public void add(Stuff stuff) {
        Connection connection = DBConnection.getConnection();;
        PreparedStatement preparedStatement = null;
        AtomicReference<String> sql = new AtomicReference<>("INSERT INTO [dbo].[STUFF] ([StuffID], [StuffName]) VALUES (?, ?);");

        try {
            preparedStatement = connection.prepareStatement(sql.get());

            preparedStatement.setLong(1, stuff.getStuffID());
            preparedStatement.setString(2, stuff.getStuffName());
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
    public List<Stuff> getAll() {
        List<Stuff> stuffList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT [StuffID], [StuffName] FROM [sq].[dbo].[STUFF];";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Stuff stuff = new Stuff();
                stuff.setStuffID(resultSet.getLong("StuffID"));
                stuff.setStuffName(resultSet.getString("StuffName"));

                stuffList.add(stuff);
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
        return stuffList;

    }

    @Override
    public Stuff get(Stuff stuff_) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT [StuffID], [StuffName] FROM [sq].[dbo].[STUFF] WHERE="+Long.toString(stuff_.getStuffID())+";";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Stuff stuff = new Stuff();
                stuff.setStuffID(resultSet.getLong("StuffID"));
                stuff.setStuffName(resultSet.getString("StuffName"));
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
        return null;
    }

    @Override
    public void update(Stuff stuff) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE [dbo].[STUFF] SET [StuffName]=? WHERE [StuffID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stuff.getStuffName());

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
    public void remove(Stuff stuff) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM [dbo].[STUFF] WHERE [StuffID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, stuff.getStuffID());
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
