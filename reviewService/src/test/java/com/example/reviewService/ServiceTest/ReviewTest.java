package com.example.reviewService.ServiceTest;

import com.example.reviewService.Entity.Review;
import com.example.reviewService.Repository.ReviewDAO;
import com.example.reviewService.Service.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReviewTest {
    @Mock
    private ReviewDAO reviewDAO;
    @InjectMocks
    private ReviewServiceImpl reviewService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetAllReviews(){
        Review review1 = new Review(5.5,1,"joe",1);
        Review review2 = new Review(5.5,2,"mama",2);
        List<Review> reviewList = Arrays.asList(review1,review2);
        when(reviewDAO.findAll()).thenReturn(reviewList);

        List<Review> res = reviewService.getReviews();
        assertEquals(2,res.size());
        assertEquals(1,1);
        assertEquals(2,2);
    }
    @Test
    public void testAddReview(){
        Review review1 = new Review(5.5,1,"joe",1);
        when(reviewDAO.save(review1)).thenReturn(review1);
        Review review = reviewService.createReview(review1);
        assertEquals(review,review1);
    }
    @Test
    public void testUpdateReview(){
        Review review1 = new Review(5.5,1,"joe",1);
        when(reviewDAO.save(review1)).thenReturn(review1);
        Review review = reviewService.updateReview(review1);
        assertEquals(review1,review);
    }

    @Test
    public void testDeleteReview(){
        doNothing().when(reviewDAO).deleteById(1L);
        String result = reviewService.deleteReview(1L);
        assertEquals("Review has been deleted",result);
        verify(reviewDAO).deleteById(1L);
    }

    @Test
    public void testGetProductReview(){
        Review review1 = new Review(5.5,1,"joe",1);
        List<Review> reviews = List.of(review1);
        when(reviewDAO.findByItemId(1L)).thenReturn(reviews);
        List<Review> result = reviewService.getItemReview(1L);
        assertEquals(1,result.size());
        assertEquals(5.5,result.get(0).getScore());
        assertEquals(1,result.get(0).getItemId());
        assertEquals("joe",result.get(0).getUsername());
        assertEquals(1,result.get(0).getUserId());
    }
    @Test
    public void testGetOneReview(){
        Review review = new Review(5.5,1,"joe",1);
        when(reviewDAO.findById(1L)).thenReturn(Optional.of(review));
        Review result = reviewService.getOneReview(1L);
        assertEquals(review,result);
    }

}
