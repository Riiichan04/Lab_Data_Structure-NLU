package lab12.task1;
import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        orders = new LinkedList<>();
    }

    public void add(Order order, Order... other) {
        orders.add(order);
        orders.addAll(Arrays.asList(other));
    }

    public Product maxProduct() {
        return orders.stream().flatMap(o -> o.getItems().stream()).map(OrderItem::getItem).max(Comparator.comparingInt(Product::getPrice)).get();
    }

    public HashMap<String, Integer> productTypesStatistics() {
        return new HashMap<>(orders.stream().flatMap(o -> o.getItems().stream()).collect(Collectors.toMap(OrderItem::getType, OrderItem::getAmount, (amount1, amount2) -> amount1 + amount2)));
    }

    public TreeSet<Order> ordersByCost() {
        return orders.stream().collect(Collectors.toCollection(() -> new TreeSet<>((o1, o2) -> {
            if (o1.cost() - o2.cost() == 0) return o1.getDate().compareTo(o2.getDate());
            else {
                return o1.cost() - o2.cost();
            }
        })));
    }

    public static void main(String[] args) {
        Product p1 = new Product("1", "AAA", 120, new Date(2020, Calendar.JANUARY, 20));
        Product p2 = new Product("2", "BBB", 1200, new Date(2023, Calendar.SEPTEMBER, 23));
        Product p3 = new Product("3", "CCC", 420, new Date(2021, Calendar.JULY, 21));
        Product p4 = new Product("4", "DDD", 660, new Date(2022, Calendar.DECEMBER, 1));
        Product p5 = new Product("5", "EEE", 543, new Date(2019, Calendar.NOVEMBER, 2));
        OrderItem o1 = new OrderItem(p1, 120);
        OrderItem o2 = new OrderItem(p2, 200);
        OrderItem o3 = new OrderItem(p2, 313);
        OrderItem o4 = new OrderItem(p4, 563);
        OrderItem o5 = new OrderItem(p5, 758);
        OrderItem o6 = new OrderItem(p3, 313);
        Order order1 = new Order("1011", "ABCDE", "PQRST", new Date());
        Order order2 = new Order("1211", "FGIHJ", "KLMNO", new Date());
        order1.add(o1, o2, o3);
        order2.add(o4, o5);
        OrderManager om = new OrderManager();
        om.add(order1, order2);

        System.out.println(om.maxProduct());
        System.out.println(om.productTypesStatistics());
        System.out.println(om.ordersByCost());
    }
}
