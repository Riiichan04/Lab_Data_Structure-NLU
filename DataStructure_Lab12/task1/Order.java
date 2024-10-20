package lab12.task1;

import java.util.*;
import java.util.stream.Collectors;

public class Order {
    private String id;
    private String customer;
    private String employee;
    private Date date;
    private List<OrderItem> items;

    public Order(String id, String customer, String employee, Date date) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.items = new LinkedList<>();
    }

    public Order() {
        this.id = null;
        this.customer = null;
        this.employee = null;
        this.date = null;
        this.items = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getEmployee() {
        return employee;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void add(OrderItem item, OrderItem... other) {
        this.items.add(item);
        this.items.addAll(Arrays.asList(other));
    }
    public int cost() {
        int result = 0;
        for (OrderItem item : items) result += item.getItem().getPrice();
        return result;
    }

    @Override
    public String toString() {
        return this.id + " " + Arrays.toString(this.items.toArray());
    }
}
