package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);

    private Book first = new Book(1, "lord of the rings", 1000, "Tolkien");
    private Book second = new Book(2, "Sapiens", 700, "Harari");
    private Book third = new Book(3, "Zuleikha", 500, "Yakhina");

    private Smartphone fourth = new Smartphone(4, "Apple 12", 100_000, "Apple");
    private Smartphone fifth = new Smartphone(5, "Apple 11 pro", 80_000, "Apple");
    private Smartphone sixth = new Smartphone(6, "Galaxy", 80_000, "Samsung");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(fourth);
        productManager.add(fifth);
        productManager.add(sixth);
    }

    @Test
    void shouldSearchBookByName() {
        String text = "lord of the rings";

        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        String text = "Harari";

        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameSecond() {
        String text = "Zuleikha";

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        String text = "Apple 12";

        Product[] expected = new Product[]{fourth};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        String text = "Samsung";

        Product[] expected = new Product[]{sixth};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearch() {
        assertEquals(0, productManager.searchBy("nothing").length);
    }
}