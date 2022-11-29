package com.example.onebox.service;

import com.example.onebox.model.Cart;
import com.example.onebox.DTO.CartDto;
import com.example.onebox.model.Product;
import com.example.onebox.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> findById(Long id){
        return cartRepository.findById(id);
    }

    public void deleteCart(Long id){
        if(cartRepository.findById(id).isPresent()){
            cartRepository.deleteAll();
        }
    }

    public Cart createCart(CartDto cartDto){
        Cart cart = new Cart();
        cart.setCreationdDate(cartDto.getCreationdDate());

        return cartRepository.save(cart);

    }
}
