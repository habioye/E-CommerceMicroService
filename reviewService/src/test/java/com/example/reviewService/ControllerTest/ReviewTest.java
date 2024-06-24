package com.example.reviewService.ControllerTest;

import com.example.reviewService.Controller.ReviewController;

import com.example.reviewService.Entity.Review;
import com.example.reviewService.Service.ReviewServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReviewServiceImpl reviewService;

    @Test
    public void testGetAllReviews() throws Exception {
        Review review1 = new Review(5.5,1,"joe",1);
        Review review2 = new Review(5.5,1,"mama",2);
        List<Review> reviewList = Arrays.asList(review1,review2);
        Mockito.when(reviewService.getReviews()).thenReturn(reviewList);
        mockMvc.perform(MockMvcRequestBuilders.get("/review"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].score",is(5.5)))
                .andExpect(jsonPath("$[0].itemId",is(1)))
                .andExpect(jsonPath("$[0].username",is("joe")))
                .andExpect(jsonPath("$[0].userId",is(1)))

                .andExpect(jsonPath("$[1].score",is(5.5)))
                .andExpect(jsonPath("$[1].itemId",is(1)))
                .andExpect(jsonPath("$[1].username",is("mama")))
                .andExpect(jsonPath("$[1].userId",is(2)));
    }
    @Test
    public void testAddReviews() throws Exception {
        Review review1 = new Review(5.5,1,"joe",1);
        Mockito.when(reviewService.createReview(review1)).thenReturn(review1);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/review")
                        .content(objectMapper.writeValueAsString(review1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.score",is(5.5)))
//                .andExpect(jsonPath("$.itemId",is(1)))
//                .andExpect(jsonPath("$.username",is("joe")))
//                .andExpect(jsonPath("$.userId",is(1)));
        MvcResult mvcResult = result.andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.println("Response JSON: " + responseString);
        result.andExpect(jsonPath("$.score", is(5.5)))
                .andExpect(jsonPath("$.itemId", is(1)))
                .andExpect(jsonPath("$.username", is("joe")))
                .andExpect(jsonPath("$.userId", is(1)));

    }

}
