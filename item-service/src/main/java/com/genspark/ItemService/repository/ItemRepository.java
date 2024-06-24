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
    @Query(value = "SELECT i from Items i WHERE i.reviewId LIKE reviewId", nativeQuery = true)
    List<Items> findByReviewId(int reviewId);

    @Query(value = "SELECT i from Items i WHERE i.vendorId LIKE vendorId ", nativeQuery = true)
    List<Items> findByVendorId(int vendorId);

    @Query(value = "SELECT i from Items i WHERE i.score LIKE score", nativeQuery = true)
    List<Items> findByScore(double score);

    @Query(value = "SELECT i from Items i WHERE i.price LIKE price", nativeQuery = true)
    List<Items> findByPrice(int price);

    @Query(value = "SELECT DISTINCT Items.description FROM Items item", nativeQuery = true)
    List<Items> findByDescription(String description);

}
