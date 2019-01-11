package service;

import daos.DAO;
import daos.DBStoreStuffDAO;
import daos.StoreStuffDAO;
import daos.entity.Store;
import daos.entity.Stuff;

public class StoreService {
    private final DAO<Store> storeDAO;
    private final StoreStuffDAO storeStuffDAO;
    public StoreService(DAO<Store> storeDAO, StoreStuffDAO storeStuffDAO) {
        this.storeDAO = storeDAO;
        this.storeStuffDAO = storeStuffDAO;
    }
    public void createStore(Store store){
        this.storeDAO.add(store);
    }

    public void cheapestStore(Stuff stuff){
        this.storeStuffDAO.findCheapestStore(stuff);
    }

    public void byStuffName(Stuff stuff){
        this.storeStuffDAO.getByStuffName(stuff);
    }

    public void byPrice(Long ammount, Store store){
        this.storeStuffDAO.getByPrice(ammount, store);
    }
}
