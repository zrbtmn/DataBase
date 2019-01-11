package daos;

import daos.DAO;
import daos.entity.Store;
import daos.entity.StoreStuff;
import daos.entity.Stuff;


public interface StoreStuffDAO extends DAO<StoreStuff> {
    void getByStuffName(Stuff stuff);
    void findCheapestStore(Stuff stuff);
    void getByParametrs(Store store, Stuff stuff, Stuff stuff_1, Stuff stuff_2, Long long1, Long long2, Long long3);
    void getByPrice(Long ammount, Store store);
}
