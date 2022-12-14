package com.example.onebox.controller;

import com.example.onebox.model.Cart;
import com.example.onebox.service.CartService;
import com.example.onebox.service.InitMasterData;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
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
    public ResponseEntity<Cart> deleteCartById(@PathVariable Long id){
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cart/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        cartService.createCart(cart);
        return ResponseEntity.created(URI.create("/cart/"+cart.getId())).build();
    }
}
