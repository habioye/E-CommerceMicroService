package com.genspark.ItemService.client;

import com.genspark.ItemService.entity.Items;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service")
public interface ItemsClient {

    @GetMapping("/items/items/{id}")
    Items findById(@PathVariable long id);

}
