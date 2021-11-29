package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(11, "core Java", 500, "author");
    private Book second = new Book(2, "Sapiens", 700, "Harari");
    private Book third = new Book(3, "Zuleikha", 500, "Yakhina");

    @BeforeEach
    public void setUp() {
        repository.save(coreJava);
        repository.save(second);
        repository.save(third);
    }


    @Test
    void shouldRemoveById() {
        repository.removeById(11);
        Product[] expected = new Product[]{second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(999));

    }
}