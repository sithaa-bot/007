package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AddProductTest {
    @Test
    @DisplayName("Add product correctly")
    void addProductCorrectly() {
        ProductManager pm = new ProductManager();
        pm.addProduct("Asus", 1000);
        assertEquals(1, pm.getCount());
    }

    @Test
    @DisplayName("Add product incorrectly (duplicate product)")
    void addProductIncorrectly() {
        ProductManager pm = new ProductManager();
        pm.addProduct("Asus", 1000);
        pm.addProduct("Asus", 1000);
        assertEquals(1, pm.getCount());
    }

    @Test
    @DisplayName("Count is increased by 1 or not")
    void countIncreasedByOne() {
        ProductManager pm = new ProductManager();
        pm.addProduct("Asus", 1000);
        assertEquals(1, pm.getCount());
    }
}
