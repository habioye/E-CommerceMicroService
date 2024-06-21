package com.genspark.ItemService.entity;

public record Items(Long id, String description, int price, int reviewId, int vendorId, int score) {
}