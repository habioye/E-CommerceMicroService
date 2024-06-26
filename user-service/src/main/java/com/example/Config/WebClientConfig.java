package com.example.Config;

import com.example.Client.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    // The filter function
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    // Helper method
    @Bean
    public WebClient reviewWebClient() {
        return WebClient.builder()
                .baseUrl("http://review-service")
                .filter(filterFunction)
                .build();
    }

    //Creates a client to use review services

    @Bean
    public ReviewClient employeeClient() {
        WebClientAdapter webClientAdapter = WebClientAdapter.create(reviewWebClient());
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
        return httpServiceProxyFactory.createClient(ReviewClient.class);
    }

}
