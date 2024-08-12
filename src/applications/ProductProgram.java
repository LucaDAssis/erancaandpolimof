package applications;

import entities.Product;
import entities.UsedProduct;
import entities.importedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println(" Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < n; i++) {
            System.out.println(" Product #" + i +" data:");
            System.out.print("  Common, usedorimported(c/u/i)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'c') {
                products.add(new Product(name, price));
            }
            else if (ch == 'u') {
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(name, price, date));
            } else {
                System.out.print("Taxa de importacao: ");
                double customsFee = sc.nextDouble();
                products.add(new importedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for (Product prod : products) {
            System.out.println(prod.priceTag());
        }


        sc.close();

    }

}
