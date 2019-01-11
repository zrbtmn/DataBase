package service;

import daos.DAO;
import daos.DBStuffDAO;
import daos.entity.Stuff;

public class StuffService {
    private final DAO<Stuff> stuffDAO;

    public StuffService(DAO<Stuff> stuffDAO) {
        this.stuffDAO = stuffDAO;
    }
    public void createStuff(Stuff stuff){
        this.stuffDAO.add(stuff);
    }
}
