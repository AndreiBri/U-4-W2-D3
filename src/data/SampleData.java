package data;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static final List<Product> PRODUCTS = new ArrayList<>();
    public static final List<Customer> CUSTOMERS = new ArrayList<>();
    public static final List<Order> ORDERS = new ArrayList<>();

    static {

        // Prodotti
        Product p1 = new Product(1L, "Libro Java", "Books", 150.0);
        Product p2 = new Product(2L, "Libro Python", "Books", 80.0);
        Product p3 = new Product(3L, "Giocattolo Baby", "Baby", 30.0);
        Product p4 = new Product(4L, "Maglietta Boys", "Boys", 45.0);
        Product p5 = new Product(5L, "Libro SQL", "Books", 120.0);
        Product p6 = new Product(6L, "Peluche Baby", "Baby", 20.0);
        Product p7 = new Product(7L, "Pantaloni Boys", "Boys", 55.0);

        PRODUCTS.addAll(List.of(p1, p2, p3, p4, p5, p6, p7));

        // Clienti
        Customer c1 = new Customer(1L, "Mario Rossi", 1);
        Customer c2 = new Customer(2L, "Luigi Blu", 2);
        Customer c3 = new Customer(3L, "Anna Verdi", 2);

        CUSTOMERS.addAll(List.of(c1, c2, c3));

        // Ordini
        Order o1 = new Order(1L, "Delivered", LocalDate.of(2026, 1, 15), LocalDate.of(2026, 1, 20), List.of(p1, p3), c1);
        Order o2 = new Order(2L, "Delivered", LocalDate.of(2026, 2, 10), LocalDate.of(2026, 2, 15),
                List.of(p2, p4), c2);
        Order o3 = new Order(3L, "Delivered", LocalDate.of(2026, 3, 5), LocalDate.of(2026, 3, 10),
                List.of(p5, p6), c3);
        Order o4 = new Order(4L, "Delivered", LocalDate.of(2026, 4, 10), LocalDate.of(2026, 4, 15),
                List.of(p7), c1);

        ORDERS.addAll(List.of(o1, o2, o3, o4));
    }
}
