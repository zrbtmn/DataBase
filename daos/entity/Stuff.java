package daos.entity;

public class Stuff {
    private Long stuffID;
    private String stuffName;

    public Stuff() {

    }

    public Long getStuffID() {
        return this.stuffID;
    }

    public Stuff setStuffID(Long stuffID) {
        this.stuffID = stuffID;
        return this;
    }

    public String getStuffName() {
        return this.stuffName;
    }

    public Stuff setStuffName(String stuffName) {
        this.stuffName = stuffName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stuff)) return false;

        Stuff stuff = (Stuff) o;

        if (getStuffID() != null ? !getStuffID().equals(stuff.getStuffID()) : stuff.getStuffID() != null) return false;
        return getStuffName() != null ? getStuffName().equals(stuff.getStuffName()) : stuff.getStuffName() == null;
    }

    @Override
    public int hashCode() {
        int result = getStuffID() != null ? getStuffID().hashCode() : 0;
        result = 31 * result + (getStuffName() != null ? getStuffName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "StuffID=" + stuffID +
                ", StuffName='" + stuffName + '\'' +
                '}';
    }
}
