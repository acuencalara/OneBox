package com.example.onebox.repository;

import com.example.onebox.model.Cart;
import com.example.onebox.model.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {

        Product productOne = new Product("Lorem ipsum", BigDecimal.valueOf(400));
        Product productTwo = new Product("Lorem ipsum", BigDecimal.valueOf(200));

        productRepository.save(productOne);
        productRepository.save(productTwo);

        Cart cartOne = new Cart(LocalDate.now(),productRepository.findAll());
        cartRepository.save(cartOne);


    }

    @AfterEach
    void tearDown() {
        cartRepository.deleteAll();
        productRepository.deleteAll();

    }

    @Test
    @DisplayName("Test creation cart")
    public void createCartTest(){
        Optional<Cart> cartTest=cartRepository.findById(1L);
        Assertions.assertEquals(1L, cartTest.get().getId());
    }

    @Test
    @DisplayName("Test creation product")
    public void createProductTest(){
        List<Product> listProductTest=productRepository.findAll();
        Assertions.assertEquals(2,listProductTest.size());
    }
}