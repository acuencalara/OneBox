package com.example.onebox.service;

import com.example.onebox.model.Cart;
import com.example.onebox.model.Product;
import com.example.onebox.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
        return cartRepository.findById(id);
    }

    public void deleteCart(Long id){
        if(cartRepository.findById(id).isPresent()){
            cartRepository.deleteAll();
        }
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);

    }
}
