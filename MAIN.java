package Testing;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product discount (optional, default 0): ");
                    double discount = scanner.nextDouble();

                    manager.addProduct(name, price, discount);
                    System.out.println("Product added.");
                    break;

                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    Product removedProduct = manager.removeProduct(removeName);
                    if (removedProduct != null) {
                        System.out.println("Removed product: " + removedProduct.getName());
                    }
                    break;

                case 3:
                    System.out.print("Enter existing product name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new product price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new product discount: ");
                    double newDiscount = scanner.nextDouble();

                    if (manager.updateProduct(oldName, newName, newPrice, newDiscount)) {
                        System.out.println("Product updated.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Product List ---");
                    for (int i = 0; i < manager.getCount(); i++) {
                        Product product = manager.getProduct(i);
                        if(product != null){
                            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Discount: " + product.getDiscount() + "%");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}