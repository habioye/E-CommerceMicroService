package com.genspark.ItemService.controller;

import com.genspark.ItemService.Service.ItemService;
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
    private ItemService service;

    @GetMapping("/items")
    public List<Items> findAll(@RequestBody Items item) {
        LOGGER.info("Items found: {}", item);
        return service.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Items findById(Long itemId){
        LOGGER.info("Receiving item by id: {}", itemId);
        return service.getById(itemId);
    }

    @GetMapping("/items/{vendorId}")
    public List<Items> findByVendorId(@PathVariable int vendorId){
        LOGGER.info("Receiving items by vendorID: {}", vendorId);
        return this.service.getByVendorId(vendorId);
    }

    @GetMapping("/items/{reviewId}")
    public List<Items> findByReviewId(@PathVariable int reviewId){
        LOGGER.info("Receiving items by reviewID: {}", reviewId);
        return this.service.getByReviewId(reviewId);
    }
    @GetMapping("/items/{description}")
    public List<Items> findByDescription(@PathVariable String description){
        LOGGER.info("Receiving items by the description: {}", description);
        return this.service.getByDescription(description);
    }

    @GetMapping("/items/{score}")
    public List<Items> findByScore(@PathVariable double score){
        LOGGER.info("Receiving items with the review score: {}", score);
        return this.service.getByScore(score);
    }

    @GetMapping("/items/{price}")
    public List<Items> findByPrice(@PathVariable int price){
        LOGGER.info("Receiving item by price: {}", price);
        return this.service.getByPrice(price);
    }

    @PostMapping
    public Items addItem(@RequestBody Items item){
        LOGGER.info("Items added: {}", item);
        return service.addItems(item);
    }

    @PutMapping
    public Items updateItem(@RequestBody Items item){
        LOGGER.info("Items updated: {}", item);
        return service.updateItems(item);
    }

    // delete a item
    @DeleteMapping
    public String deleteItem(@PathVariable Long ItemId){
        LOGGER.info("deleting items of ID: {}", ItemId);
        return this.service.deleteItem(ItemId);
    }









}
