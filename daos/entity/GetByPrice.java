package daos.entity;

public class GetByPrice {
    private Long count;
    private String stuffName;

    public GetByPrice() {

    }

    @Override
    public String toString() {
        return "GetByPrice{" +
                "count=" + count +
                ", stuffName='" + stuffName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetByPrice)) return false;

        GetByPrice that = (GetByPrice) o;

        if (getCount() != null ? !getCount().equals(that.getCount()) : that.getCount() != null) return false;
        return getStuffName() != null ? getStuffName().equals(that.getStuffName()) : that.getStuffName() == null;
    }

    @Override
    public int hashCode() {
        int result = getCount() != null ? getCount().hashCode() : 0;
        result = 31 * result + (getStuffName() != null ? getStuffName().hashCode() : 0);
        return result;
    }

    public Long getCount() {
        return count;
    }

    public GetByPrice setCount(Long count) {
        this.count = count;
        return this;
    }

    public String getStuffName() {
        return stuffName;
    }

    public GetByPrice setStuffName(String stuffName) {
        this.stuffName = stuffName;
        return this;
    }
}
