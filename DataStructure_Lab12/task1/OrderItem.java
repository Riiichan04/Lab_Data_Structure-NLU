package lab12.task1;

public class OrderItem {
    private Product item;
    private int amount;

    public OrderItem(Product item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Product getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
    public String getType() {return this.item.getType();}
    @Override
    public String toString() {
        return this.item + " " + this.amount;
    }
}
