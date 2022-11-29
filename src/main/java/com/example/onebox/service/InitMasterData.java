package com.example.onebox.service;

import com.example.onebox.model.Cart;
import com.example.onebox.model.Product;
import com.example.onebox.repository.CartRepository;
import com.example.onebox.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InitMasterData {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public void initData(){
        productRepository.deleteAll();
        cartRepository.deleteAll();

        Product productOne = new Product("Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                BigDecimal.valueOf(100));
        Product productTwo = new Product("Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                BigDecimal.valueOf(34));

        productRepository.save(productOne);
        productRepository.save(productTwo);

        Cart cartOne= new Cart(LocalDate.now(),productRepository.findAll());
        cartRepository.save(cartOne);
    }
}
