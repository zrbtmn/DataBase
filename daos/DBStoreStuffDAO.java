package daos;

import daos.entity.Store;
import daos.entity.StoreStuff;
import daos.entity.Stuff;
import daos.entity.GetByPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DBStoreStuffDAO implements StoreStuffDAO {

    @Override
    public void add(StoreStuff storeStuff) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        AtomicReference<String> sql = new AtomicReference<>("INSERT INTO dbo.STORE_STUFF (StoreStuffID, StoreID, StuffID, StoreStuffQty, StoreStuffCost) VALUES (?, ?, ?, ?, ?);");
        try {
            preparedStatement = connection.prepareStatement(sql.get());

            preparedStatement.setLong(1, storeStuff.getStoreStuffID());
            preparedStatement.setLong(2, storeStuff.getStoreID());
            preparedStatement.setLong(3, storeStuff.getStuffID());
            preparedStatement.setLong(4, storeStuff.getStoreStuffQty());
            preparedStatement.setLong(5, storeStuff.getStoreStuffCost());

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
    public List<StoreStuff> getAll() {
        Connection connection = DBConnection.getConnection();
        List<StoreStuff> stuffList = new ArrayList<>();
        String sql = "SELECT StoreStuffID, StoreID, StuffID, StoreStuffQty, StoreStuffCost FROM [sq].[dbo].[STORE_STUFF];";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                StoreStuff storeStuff = new StoreStuff();
                storeStuff.setStoreStuffID(resultSet.getLong("StoreStuffID"));
                storeStuff.setStoreID(resultSet.getLong("StoreID"));
                storeStuff.setStuffID(resultSet.getLong("StuffID"));
                storeStuff.setStoreStuffQty(resultSet.getLong("StoreStuffQty"));
                storeStuff.setStoreStuffCost(resultSet.getLong("StoreStuffCost"));
                stuffList.add(storeStuff);
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
    public StoreStuff get(StoreStuff storeStuff_) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT StoreStuffID, StoreID, StuffID, StoreStuffQty, StoreStuffCost FROM [sq].[dbo].[STORE_STUFF] WHERE StoreStuff="+Long.toString(storeStuff_.getStoreStuffID())+"";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                StoreStuff storeStuff = new StoreStuff();
                storeStuff.setStoreStuffID(resultSet.getLong("StoreStuffID"));
                storeStuff.setStoreID(resultSet.getLong("StoreID"));
                storeStuff.setStuffID(resultSet.getLong("StuffID"));
                storeStuff.setStoreStuffQty(resultSet.getLong("StoreStuffQty"));
                storeStuff.setStoreStuffCost(resultSet.getLong("StoreStuffCost"));

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
        return storeStuff_;
    }

    @Override
    public void update(StoreStuff storeStuff) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE [dbo].[STORE_STUFF] SET [StoreStuffQty]=?, StoreStuffCost]=?  WHERE [StoreStuffID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,storeStuff.getStoreStuffQty());
            preparedStatement.setLong(2,storeStuff.getStoreStuffCost());
            preparedStatement.setLong(3,storeStuff.getStoreStuffID());
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
    public void remove(StoreStuff storeStuff) {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM [dbo].[STORE_STUFF] WHERE [StoreStuffID]=?;";
        try {

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, storeStuff.getStoreStuffID());
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

    public void printAllStores() {
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
        for (Store stuff :storeList){
            System.out.println(stuff);
        }
    }
    public void printAllStoreStuffs() {
        Connection connection = DBConnection.getConnection();
        List<StoreStuff> stuffList = new ArrayList<>();
        String sql = "SELECT StoreStuffID, StoreID, StuffID, StoreStuffQty, StoreStuffCost FROM [sq].[dbo].[STORE_STUFF];";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                StoreStuff storeStuff = new StoreStuff();
                storeStuff.setStoreStuffID(resultSet.getLong("StoreStuffID"));
                storeStuff.setStoreID(resultSet.getLong("StoreID"));
                storeStuff.setStuffID(resultSet.getLong("StuffID"));
                storeStuff.setStoreStuffQty(resultSet.getLong("StoreStuffQty"));
                storeStuff.setStoreStuffCost(resultSet.getLong("StoreStuffCost"));
                stuffList.add(storeStuff);
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
        for (StoreStuff storeStuff :stuffList){
            System.out.println(storeStuff.toString());
        }
    }

    public void printAllStuffs() {
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

    }

    @Override
    public void getByStuffName(Stuff stuff) {
        Connection connection = DBConnection.getConnection();
        String stuffName = stuff.getStuffName();
        String sql = "SELECT V.StoreStuffID, V.StuffID, V.StoreID, V.StoreStuffQty, V.StoreStuffCost FROM STORE_STUFF V JOIN STUFF I ON V.StuffID=I.StuffID WHERE I.StuffName=" + "'"+stuffName+"'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()){
                StoreStuff storeStuff = new StoreStuff();
                storeStuff.setStoreStuffID(resultSet.getLong("StoreStuffID"));
                storeStuff.setStuffID(resultSet.getLong("StuffID"));
                storeStuff.setStoreID(resultSet.getLong("StoreID"));
                storeStuff.setStoreStuffQty(resultSet.getLong("StoreStuffQty"));
                storeStuff.setStoreStuffCost(resultSet.getLong("StoreStuffCost"));
                System.out.println(storeStuff.toString());

            }
        } catch (SQLException e ) {
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
    }

    public void findCheapestStore(Stuff stuff){
        Long stuffID = stuff.getStuffID();
        String stuff_ID= Long.toString(stuffID);
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT V.StoreID, V.StoreName FROM STORE V JOIN STORE_STUFF I ON V.StoreID=I.StoreID AND I.StuffID="+stuff_ID+
                " WHERE I.StoreStuffCost=(SELECT MIN(STORE_STUFF.StoreStuffCost) FROM STORE_STUFF)";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()){
                Store store = new Store();
                store.setStoreID(resultSet.getLong("StoreID"));
                store.setStoreName(resultSet.getString("StoreName"));
                System.out.println(store.toString());
            }
        } catch (SQLException e ) {
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

    }
    public void getByParametrs(Store store, Stuff stuff, Stuff stuff_1, Stuff stuff_2, Long long1, Long long2, Long long3){
        Connection connection = DBConnection.getConnection();
        String sql="SELECT * FROM STORE_STUFF V JOIN STORE I ON I.StoreID=V.StoreID " +
                "JOIN STUFF K ON K.StuffID=V.StuffID WHERE K.StuffID IN (SELECT K." +
                "( K.StuffID="+Long.toString(stuff.getStuffID())+" V.StoreStuffQty="+Long.toString(long1)+" AND I.StoreID="+Long.toString(store.getStoreID())+")" +
                ", ( K.StuffID="+Long.toString(stuff_1.getStuffID())+" AND V.StoreStuffQty="+Long.toString(long2)+" AND I.StoreID="+Long.toString(store.getStoreID())+"), " +
                "( K.StuffID="+Long.toString(stuff_2.getStuffID())+" AND V.StoreStuffQty="+Long.toString(long3)+" AND I.StoreID="+Long.toString(store.getStoreID())+") )";
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(!resultSet.next()){

                System.out.println("BAD");
            }else{
                System.out.println("OK");
            }
        } catch (SQLException e ) {
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
    }
    public void getByPrice(Long ammount, Store store){
        String sumAmmount = Long.toString(ammount);
        Connection connection = DBConnection.getConnection();
        String storeID = Long.toString(store.getStoreID());
        String storeName = store.getStoreName();
        String sql = "SELECT V.StuffName, FLOOR("+sumAmmount+"/I.StoreStuffCost) as Count "+
                "from STUFF V " +
                "JOIN STORE_STUFF I ON V.StuffID=I.StuffID "+
                "JOIN STORE K on K.StoreID=I.StoreID WHERE K.StoreName='"+storeName+"' and FLOOR("+sumAmmount+"/I.StoreStuffCost) < I.StoreStuffQty ";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                GetByPrice getByPrice = new GetByPrice();
                getByPrice.setStuffName(resultSet.getString("StuffName"));
                getByPrice.setCount(resultSet.getLong("Count"));
                System.out.println(getByPrice.toString());
            }
        } catch (SQLException e ) {
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
    }
}
