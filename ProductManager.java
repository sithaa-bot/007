package Testing;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private int count = 0;

    public void addProduct(String name, double price) {
        addProduct(name, price, 0);
    }

    public void addProduct(String name, double price, double discount) {
        if (findProduct(name) >= 0) {
            System.out.println("Can't add, product already exists.");
            return;
        }
        Product prod = new Product();
        prod.setName(name.trim());
        prod.setPrice(price);
        prod.setDiscount(discount);
        products.add(prod);
        count++;
    }

    public int findProduct(String name) {
        name = name.trim();
        for (int i = 0; i < count; i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Product removeProduct(String name) {
        int foundIndex = findProduct(name);
        if (foundIndex == -1) {
            System.out.println("Product not found!");
            return null;
        }
        Product prod = products.remove(foundIndex);
        count--;
        return prod;
    }

    public boolean updateProduct(String oldName, String newName, double newPrice, double newDiscount) {
        int foundIndex = findProduct(oldName);
        if (foundIndex == -1) {
            System.out.println("Product not found!");
            return false;
        }
        if (newDiscount < 0 || newDiscount > 100) {
            System.out.println("Invalid discount. Discount must be between 0 and 100.");
            return false;
        }
        products.get(foundIndex).setName(newName.trim());
        products.get(foundIndex).setPrice(newPrice);
        products.get(foundIndex).setDiscount(newDiscount);
        return true;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct(int index) {
        if (index >= 0 && index < count) {
            return products.get(index);
        }
        return null;
    }
}