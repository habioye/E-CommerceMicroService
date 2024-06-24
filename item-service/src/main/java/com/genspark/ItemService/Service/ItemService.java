package com.genspark.ItemService.Service;

import com.genspark.ItemService.controller.ItemsController;
import com.genspark.ItemService.entity.Items;
import com.genspark.ItemService.repository.ItemRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ItemService {

    public Logger logger = LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemRepository repo;

    public Items addItems(Items Items) {
        return repo.save(Items);
    }

    public List<Items>  getAllItems() {
        return  repo.findAll();
    }

    public Items updateItems(Items Items) {
        return repo.save(Items);
    }


    public String deleteItem(long itemID) {
        logger.info(String.format("Attempting to delete item by item ID: %s", itemID));
        this.repo.deleteById(itemID);
        return "Item Deleted Successfully";
    }
    public Items getById(Long itemID) {
        Optional<Items> i = this.repo.findById(itemID);
        Items item = null;
        if (i.isPresent()) {
            item = i.get();
        }
        return item;
    }

    public List<Items> getByVendorId(int vendorId){
        return repo.findByVendorId(vendorId);
    }

    public List<Items> getByReviewId(int reviewId){
        return repo.findByReviewId(reviewId);
    }

    public List<Items> getByScore(double score){
        return repo.findByScore(score);
    }

    public List<Items> getByPrice(double price){
        return repo.findByPrice(price);
    }
    public List<Items> getByDescription(String description){
        return repo.findByDescription(description);
    }

}
