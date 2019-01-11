package service;

import daos.*;
import daos.entity.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService extends DBConnection {
    private final DAO<Store> storeDAO;
    private final StoreStuffDAO storeStuffDAO;
    private final DAO<Stuff> stuffDAO;
    public OrderService(DAO<Store> storeDAO, DAO<Stuff> stuffDAO, StoreStuffDAO storeStuffDAO) {
        this.storeDAO = storeDAO;
        this.storeStuffDAO = storeStuffDAO;
        this.stuffDAO = stuffDAO;
    }

    public void byParametrs(Store store, Stuff stuff, Stuff stuff1, Stuff stuff2, Long long1, Long long2, Long long3){
        DBStoreStuffDAO storeStuffDAO = new DBStoreStuffDAO();
        List<StoreStuff> storeStuffs = new ArrayList<>();
        for (StoreStuff st: storeStuffs
             ) {
            StoreStuff res = storeStuffDAO.get(st);
        }

    }

}
