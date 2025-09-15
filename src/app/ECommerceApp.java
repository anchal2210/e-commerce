package src.app;

import src.model.Product;
import src.service.ProductService;
import src.service.OrderService;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nE-Commerce Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Order Product");
            System.out.println("4. View Ordered Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product product = new Product(id, name, price);
                    productService.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    System.out.println("Available Products:");
                    for (Product p : productService.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Enter product id to order: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    Product orderProduct = productService.getProductById(orderId);
                    if (orderProduct != null) {
                        orderService.orderProduct(orderProduct);
                        System.out.println("Product ordered successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.println("Ordered Products:");
                    for (Product p : orderService.getOrderedProducts()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
