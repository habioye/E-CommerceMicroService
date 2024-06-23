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

    @GetMapping("/items/{vendorId}")
    public List<Items> findByVendorId(@PathVariable int vendorId){
        return this.service.getByVendorId(vendorId);
    }

    @GetMapping("/items/{reviewId}")
    public List<Items> findByReviewId(@PathVariable int ReviewId){
        return this.service.getByReviewId(ReviewId);
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
        return this.service.deleteItem(ItemId);
    }









}
