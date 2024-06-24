package com.genspark.ItemService.repository;

import com.genspark.ItemService.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    List<Items> findByItemId(Long itemId);

    // Retrieves list of items where review id matches
    @Query(value = "SELECT * from Items i WHERE i.review_Id = :reviewId", nativeQuery = true)
    List<Items> findByReviewId(@Param("reviewId") int reviewId);

    // Retrieves list of items where vendor id matches
    @Query(value = "SELECT * from Items i WHERE i.vendor_Id = :vendorId ", nativeQuery = true)
    List<Items> findByVendorId(@Param("vendorId") int vendorId);

    // Retrieves list of items where score matches
    @Query(value = "SELECT * from Items i WHERE i.score = :score", nativeQuery = true)
    List<Items> findByScore(@Param("score") double score);

    // Retrieves list of items where price matches
    @Query(value = "SELECT * from Items i WHERE i.price = :price", nativeQuery = true)
    List<Items> findByPrice(@Param("price") double price);

    // Retrieves list of items where description matches
    @Query(value = "SELECT * from Items i WHERE i.description = :description", nativeQuery = true)
    List<Items> findByDescription(@Param("description") String description);

}
