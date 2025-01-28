package Testing;

public class Product {
    private String name;
    private double price = 0;
    private double discount = 0; // in percentage between 0 and 100

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
    }
}
