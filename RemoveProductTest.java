package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoveProductTest {
    private ProductManager pro;

    @BeforeEach
    void setUp() {
        pro = new ProductManager();
    }

    @Test
    @DisplayName("Remove product correctly (product name exists)")
    public void removeProductCorrectly() {
        pro.addProduct("Asus", 1000);
        pro.removeProduct("Asus");
        assertEquals(0, pro.getCount());
    }

    @Test
    @DisplayName("Remove product incorrectly (product name not exists)")
    public void removeProductIncorrectly() {
        pro.addProduct("Book", 100);
        pro.removeProduct("Java");
        assertEquals(1, pro.getCount());
    }

    @Test
    @DisplayName("Check count decreased after removal")
    public void checkCountDecreased() {
        pro.addProduct("Book", 100);
        pro.removeProduct("Book");
        assertEquals(0, pro.getCount());
    }
}