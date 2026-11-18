import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Product {

    public Product(double v) {

    }

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        Product calc = new Product();
        assertEquals(525.0,  0.01);
    }
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        assertEquals(175.0, new Product(3500.0, 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, new Product(3500.0)calc.GetTotal(), 0.01);
    }
}
