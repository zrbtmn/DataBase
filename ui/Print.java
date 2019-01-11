package ui;

import daos.*;
import daos.entity.Store;
import daos.entity.StoreStuff;
import daos.entity.Stuff;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public Print() {

    }

    public void printStores(DBStoreDAO dbStoreDAO){
        List<Store> storeList = new ArrayList<>();
        storeList=dbStoreDAO.getAll();
        for (Store store :storeList){
            System.out.println(store.toString());
        }
    }

    public void printStuffs(DBStuffDAO dbStuffDAO){
        List<Stuff> stuffList = new ArrayList<>();
        stuffList=dbStuffDAO.getAll();
        for (Stuff stuff :stuffList){
            System.out.println(stuff.toString());
        }
    }

    public void printStoreStuffs(DBStoreStuffDAO dbStoreStuffDAO){
        List<StoreStuff> storeStuffs = new ArrayList<>();
        storeStuffs=dbStoreStuffDAO.getAll();
        for (StoreStuff storeStuff:storeStuffs) {
            System.out.println(storeStuff.toString());

        }
    }
}
