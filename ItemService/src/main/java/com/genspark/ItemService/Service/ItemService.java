package com.genspark.ItemService.Service;

import com.genspark.ItemService.entity.Items;
import com.genspark.ItemService.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    @Autowired
    private ItemRepository repo;

    public Items addItems(Items Items) {
        return repo.save(Items);
    }

    public List<Items>  getAllItems() {
        return  repo.findAll();
    }

//    public Items getItemsByUserId(long userId) {
//        return repo.findItemsByUserId(userId);
//    }

    public Items updateItems(Items Items) {
        return repo.save(Items);
    }

//    public void deleteItemsByUserId(long userId) {
//        repo.deleteItemsByUserId(userId);
//    }
}
