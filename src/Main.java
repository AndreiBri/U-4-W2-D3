import data.SampleData;
import entities.Order;
import entities.Product;

import java.util.List;
import java.util.stream.Collectors;

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

                System.out.println("\n");
            }
        }

        System.out.println(" === Esercizio 3 ===\n ");
        System.out.println("Lista Prodotti con categoria BOYS e applicato 10% ogni prodotto:\n");

        List<Product> scontati = esercizio3();

        if (scontati.isEmpty()) {
            System.out.println("Nessun prodotto nella categoria Boys trovato.");
        } else {
            System.out.println("Trovati " + scontati.size() + " prodotti: \n");

            for (Product p : scontati) {
                System.out.println(" - " + p.getName());
                System.out.println("   prezzo scontato: " + p.getPrice() + " €");
                System.out.println();
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

    public static List<Product> esercizio3() {
        return SampleData.PRODUCTS.stream()
                .filter(p -> "Boys".equals(p.getCategory()))
                .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9))
                .collect(Collectors.toList());

    }

}