import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Молоко", 85);
    Product product2 = new Product(2, "Хлеб", 55);
    Product product3 = new Product(3, "Творог", 89);
    Product product4 = new Product(4, "Чай", 205);

    @Test
    public void removeByIdNotFoundArray() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });
    }

    @Test
    public void removeByIdFoundArray() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        Product[] expected = {product1, product2, product4};
        repo.remove(3);
        Assertions.assertArrayEquals(expected, repo.findAll());
    }
}
