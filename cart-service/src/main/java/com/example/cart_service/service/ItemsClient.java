package com.example.cart_service.service;

import com.example.cart_service.entity.Items;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service")
public interface ItemsClient {

    @GetMapping("/items/{id}")
    Items findById(@PathVariable long id);

}
