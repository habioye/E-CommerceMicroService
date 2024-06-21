package com.genspark.ItemService.controller;

import com.genspark.ItemService.client.ItemClient;
import com.genspark.ItemService.repository.ItemRepository;
import com.genspark.ItemService.entity.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/items")
public class ItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemRepository repository;

    @PostMapping
    public List<Items> findAll(@RequestBody Items items) {
        LOGGER.info("Items found: {}", items);
        return repository.findAll();
    }



}
