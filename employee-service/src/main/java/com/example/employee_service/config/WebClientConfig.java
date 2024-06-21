//package com.example.employee_service.config;
//
//import com.example.employee_service.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.service.annotation.*;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//import java.util.List;
//
//public class WebClientConfig {
//
//    @Autowired
//    LoadBalancedExchangeFilterFunction filterFunction;
//
//    @Bean
//    public WebClient employeeWebClient() {
//        return WebClient.builder()
//                .baseUrl("http://employee-service")
//                .filter(filterFunction)
//                .build();
//    }
//
//    @Bean
//    public EmployeeClient employeeClient() {
//        WebClientAdapter webClientAdapter = WebClientAdapter.create(employeeWebClient());
//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
//        return httpServiceProxyFactory.createClient(EmployeeClient.class);
//    }
//
//    @HttpExchange
//    public interface EmployeeClient {
//        @GetExchange("/employee/department/{departmentId}")
//        public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
//    }
//}
