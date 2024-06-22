package com.genspark.ItemService.repository;

import com.genspark.ItemService.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    List<Items> findByItemId(Long itemId);

    // Retrieves list of sellers where name matches
    @Query("SELECT i from Items i WHERE LOWER(i.reviewId) LIKE LOWER(CONCAT('%', :reviewId, '%'))")
    List<Items> findByReviewId(int reviewId);

    @Query("SELECT i from Items i WHERE LOWER(i.vendorId) LIKE LOWER(CONCAT('%', :vendorId, '%'))")
    List<Items> findByVendorId(int vendorId);

//    public ArrayList<Items> items = new ArrayList<>();
//
//    public List<Items> findAll(){
//        return items;
//    }
//
//    public Items findById(Long id){
//        return items.stream()
//        .filter(items ->
//                items.getId().equals(id))
//                .findFirst()
//                .orElseThrow();
//    }




}
