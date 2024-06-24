package com.example.cart_service.client;

import com.example.cart_service.entity.Items;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ItemsClient {

    @GetExchange("/items/items/{itemId}")
    public Items findById(@PathVariable("itemId") long id);

}
