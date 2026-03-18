import data.SampleData;
import entities.Product;

import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println(" === Esercizio 1 ===\n ");

        List<Product> libriCostosi = esercizio1();

        if (libriCostosi.isEmpty()) {
            System.out.println("Nessun libro trovato con prezzo > 100 €");
        } else {
            System.out.println("Trovati " + libriCostosi.size() + " libri costosi:");

            for (Product p : libriCostosi) {
                System.out.println(" - " + p.getName() + "-> € " + p.getPrice());
            }
        }
        System.out.println();
    }

    public static List<Product> esercizio1() {
        return SampleData.PRODUCTS.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .filter(p -> p.getPrice() > 100)
                .toList();

    }

}