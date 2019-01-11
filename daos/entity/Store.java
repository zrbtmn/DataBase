package daos.entity;


public class Store {
    private Long storeID;
    private String storeName;

    public Store(){

    }

    public Long getStoreID() {
        return this.storeID;
    }

    public Store setStoreID(Long storeID) {
        this.storeID = storeID;
        return this;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public Store setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (getStoreID() != null ? !getStoreID().equals(store.getStoreID()) : store.getStoreID() != null) return false;
        return getStoreName() != null ? getStoreName().equals(store.getStoreName()) : store.getStoreName() == null;
    }

    @Override
    public int hashCode() {
        int result = getStoreID() != null ? getStoreID().hashCode() : 0;
        result = 31 * result + (getStoreName() != null ? getStoreName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "StoreID=" + storeID +
                ", StoreName='" + storeName + '\'' +
                '}';
    }
}
