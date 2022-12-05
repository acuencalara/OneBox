package com.example.onebox.service;

import com.example.onebox.model.Cart;
import com.example.onebox.model.Product;
import com.example.onebox.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
@CacheConfig(cacheNames = "carts")
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Cacheable
    public Optional<Cart> findById(Long id){
        if(!cartRepository.findById(id).isPresent()){
            log.warn("The cart doesn't exists");
            throw new RuntimeException("The cart doesn't exist");
        }
        return cartRepository.findById(id);
    }

    public void deleteCart(Long id){
        if(cartRepository.findById(id).isPresent()){
            cartRepository.deleteAll();
        }
        if(!cartRepository.findById(id).isPresent()){
            log.warn("The cart doesn't exists");
            throw new RuntimeException("The cart doesn't exist");
        }
    }

    public Cart createCart(Cart cart){

        if(cartRepository.existsById(cart.getId())){
            log.warn("You are trying to create a cart that already exists");
            throw new RuntimeException("Cart already exists");

        }
        log.warn("New cart created");
        return cartRepository.save(cart);

    }
}
