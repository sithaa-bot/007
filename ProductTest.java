package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ProductTest {
    @Test
    @DisplayName("set name correctly")
    void setNameCorrectly() {
        Product p = new Product();
        p.setName("Sitha");
        assertEquals("Sitha", p.getName());
    }

    @Test
    @DisplayName("set name incorrectly")
    void setNameIncorrect() {
        Product p = new Product();
        p.setName("  ");
        assertNull(p.getName());
    }
    @Test 
    @DisplayName("set price correctly(price is greater than 0)")
    void setPriceCorrectly() {
        Product p = new Product();
        p.setPrice(100);
        assertEquals(100, p.getPrice());
    }
    @Test
    @DisplayName("set price incorrectly(price is less than 0)")
    void setPriceIncorrect() {
        Product p = new Product();
        p.setPrice(-100);
        assertEquals(0, p.getPrice());
    }
    @Test
    @DisplayName("set discount correctly(discount is between 0 and 100)")
    void setDiscountCorrectly() {
        Product p = new Product();
        p.setDiscount(50);
        assertEquals(50, p.getDiscount());
    }
    @Test
    @DisplayName("set discount incorrectly(discount is less than 0)")
    void setDiscountIncorrect() {
        Product p = new Product();
        p.setDiscount(-50);
        assertEquals(0, p.getDiscount());
    }
    
}
