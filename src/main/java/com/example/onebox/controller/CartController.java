package com.example.onebox.controller;

import com.example.onebox.model.Cart;
import com.example.onebox.service.CartService;
import com.example.onebox.service.InitMasterData;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private CartService cartService;

    private final InitMasterData initMasterData;

    @GetMapping("/initData/")
    public void initData(){
        this.initMasterData.initData();
    }

    @GetMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cart> getCartById(@PathVariable Long id){
        return cartService.findById(id);
    }

    @DeleteMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartById(@PathVariable Long id){
        cartService.deleteCart(id);
    }

    @PostMapping("/cart/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }
}
