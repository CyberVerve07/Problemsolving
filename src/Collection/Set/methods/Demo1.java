package Collection.Set.methods;

public class Demo1 {
    String userName;
    String orderId;
    int price;

    public Demo1(String userName, String orderId, int price) {
        this.userName = userName;
        this.orderId = orderId;
        this.price = price;
    }

    // Fields ke basis par hashCode
    @Override
    public int hashCode() {
        return userName.hashCode() + orderId.hashCode() + price;
    }

    // Fields ke basis par equals (Same class ke object se cast karna hai)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Demo1 other = (Demo1) obj;
        return this.price == other.price &&
                this.userName.equals(other.userName) &&
                this.orderId.equals(other.orderId);
    }
}