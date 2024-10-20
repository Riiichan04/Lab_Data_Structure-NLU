package lab12.task1;

import java.util.Date;

public class Product {
    private String name;
    private String type;
    private int price;
    private Date expiredDate;

    public Product(String name, String type, int price, Date expiredDate) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.expiredDate = expiredDate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    @Override
    public String toString() {
        return this.name + " " + this.type + " " + this.price;
    }
}
