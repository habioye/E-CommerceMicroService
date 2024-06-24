package org.example.Client;

package com.genspark.department_service.client;

import com.genspark.department_service.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface ReviewClient {
    @PostExchange("/review")
    public Review addReview(@RequestBody Review review);
}
