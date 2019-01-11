package daos.entity;

public class StoreStuff {
    private Long storeStuffID;
    private Long storeID;
    private Long stuffID;
    private Long storeStuffQty;
    private Long storeStuffCost;

    public StoreStuff() {

    }

    public Long getStoreStuffID() {
        return this.storeStuffID;
    }

    public StoreStuff setStoreStuffID(Long storeStuffID) {
        this.storeStuffID = storeStuffID;
        return this;
    }

    public Long getStoreID() {
        return this.storeID;
    }

    public StoreStuff setStoreID(Long storeID) {
        this.storeID = storeID;
        return this;
    }

    public Long getStuffID() {
        return this.stuffID;
    }

    public StoreStuff setStuffID(Long stuffID) {
        this.stuffID = stuffID;
        return this;
    }

    public Long getStoreStuffQty() {
        return this.storeStuffQty;
    }

    public StoreStuff setStoreStuffQty(Long storeStuffQty) {
        this.storeStuffQty = storeStuffQty;
        return this;
    }

    public Long getStoreStuffCost() {
        return this.storeStuffCost;
    }

    public StoreStuff setStoreStuffCost(Long storeStuffCost) {
        this.storeStuffCost = storeStuffCost;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreStuff)) return false;

        StoreStuff that = (StoreStuff) o;

        if (getStoreStuffID() != null ? !getStoreStuffID().equals(that.getStoreStuffID()) : that.getStoreStuffID() != null)
            return false;
        if (getStoreID() != null ? !getStoreID().equals(that.getStoreID()) : that.getStoreID() != null) return false;
        if (getStuffID() != null ? !getStuffID().equals(that.getStuffID()) : that.getStuffID() != null) return false;
        if (getStoreStuffQty() != null ? !getStoreStuffQty().equals(that.getStoreStuffQty()) : that.getStoreStuffQty() != null)
            return false;
        return getStoreStuffCost() != null ? getStoreStuffCost().equals(that.getStoreStuffCost()) : that.getStoreStuffCost() == null;
    }

    @Override
    public int hashCode() {
        int result = getStoreStuffID() != null ? getStoreStuffID().hashCode() : 0;
        result = 31 * result + (getStoreID() != null ? getStoreID().hashCode() : 0);
        result = 31 * result + (getStuffID() != null ? getStuffID().hashCode() : 0);
        result = 31 * result + (getStoreStuffQty() != null ? getStoreStuffQty().hashCode() : 0);
        result = 31 * result + (getStoreStuffCost() != null ? getStoreStuffCost().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoreStuff{" +
                "StoreStuffID=" + storeStuffID +
                ", StoreID=" + storeID +
                ", StuffID=" + stuffID +
                ", StoreStuffQty=" + storeStuffQty +
                ", StoreStuffCost=" + storeStuffCost +
                '}';
    }
}
