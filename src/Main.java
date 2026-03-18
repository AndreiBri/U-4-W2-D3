import data.SampleData;
import entities.Order;
import entities.Product;

import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println(" === Esercizio 1 ===\n ");
        System.out.println("Lista prodotti categoria BOOKS con prezzo > 100 :\n");

        List<Product> libriCostosi = esercizio1();

        if (libriCostosi.isEmpty()) {
            System.out.println("Nessun libro trovato con prezzo > 100 €");
        } else {
            System.out.println("Trovati " + libriCostosi.size() + " libri costosi:");

            for (Product p : libriCostosi) {
                System.out.println(" - " + p.getName() + "-> € " + p.getPrice());
            }
        }
        System.out.println("\n");

        System.out.println(" === Esercizio 2 ===\n ");
        System.out.println("Ordini che contengono almeno un prodotto categoria BABY:\n");

        List<Order> ordiniConBaby = esercizio2();

        if (ordiniConBaby.isEmpty()) {
            System.out.println("Nessun ordine trovato con prodotti della categoria Baby.");
        } else {
            System.out.println("Trovati " + ordiniConBaby.size() + " ordini:\n");

            for (Order ordine : ordiniConBaby) {
                System.out.println("Ordine " + ordine.getId());
                System.out.println(" Cliente: " + ordine.getCustomer().getName() + " (tier " + ordine.getCustomer().getTier() + " )");
                System.out.println(" Data ordine: " + ordine.getOrderDate());
                System.out.println(" Stato: " + ordine.getStatus());
                System.out.println(" Prodotti inclusi:");

                for (Product p : ordine.getProducts()) {
                    System.out.println("  -" + p.getName() + " (" + p.getCategory() + " ) €" + p.getPrice());
                }
            }
        }


    }

    public static List<Product> esercizio1() {
        return SampleData.PRODUCTS.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .filter(p -> p.getPrice() > 100)
                .toList();

    }

    public static List<Order> esercizio2() {
        return SampleData.ORDERS.stream()
                .filter(ordine -> ordine.getProducts().stream()
                        .anyMatch(p -> "Baby".equals(p.getCategory())))
                .toList();
    }

}