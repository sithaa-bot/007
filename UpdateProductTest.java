package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateProductTest {
    private ProductManager pro;

    @BeforeEach
    void setUp() {
        pro = new ProductManager();
    }

    @Test
    @DisplayName("Update product correctly (product name exists)")
    public void updateProductCorrectly() {
        pro.addProduct("Asus", 1000);
        pro.updateProduct("Asus", "Dell", 2000, 10);
        assertEquals("Dell", pro.getProduct(0).getName());
        assertEquals(2000, pro.getProduct(0).getPrice());
        assertEquals(10, pro.getProduct(0).getDiscount());
    }

    @Test
    @DisplayName("Update product incorrectly (product name not exists)")
    public void updateProductIncorrectly() {
        pro.addProduct("Book", 100);
        pro.updateProduct("Java", "C++", 200, 20);
        assertEquals("Book", pro.getProduct(0).getName());
        assertEquals(100, pro.getProduct(0).getPrice());
        assertEquals(0, pro.getProduct(0).getDiscount());
    }

    @Test
    @DisplayName("Update product incorrectly (product name exists but new discount is less than 0 or greater than 100)")
    public void updateProductIncorrectlyNameBlank() {
        pro.addProduct("Book", 100);
        pro.updateProduct("Book", "Java", 200, -20);
        assertEquals("Book", pro.getProduct(0).getName()); // Name should not change
        assertEquals(100, pro.getProduct(0).getPrice()); // Price should not change
        assertEquals(0, pro.getProduct(0).getDiscount()); // Discount should not change
    }

    @Test
    @DisplayName("Check for count is stay the same as before the update")
    public void checkCountStayTheSame() {
        pro.addProduct("Book", 100);
        pro.updateProduct("Book", "Java", 200, 20);
        assertEquals(1, pro.getCount());
    }
}