//package com.impl.vk.controller;
//
//import com.api.dto.requestDto.Id;
//import com.api.dto.responseDto.Common;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.impl.vk.entity.Customer;
//import com.impl.vk.repository.CustomerRepository;
//import com.impl.vk.service.CreateClientService;
//import lombok.Data;
//import lombok.extern.log4j.Log4j;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@Data
//public class ControllerTest {
//    @Autowired
//    private CreateClientService testService;
//
//    @Value("${ebany.url}")
//    private String ebanyUrl;
//
//    @Autowired
//    private CustomerRepository repository;
//
//
//
//    @PostMapping(value = "/vk/api")
//    public void testToApi(@RequestBody Common common) {
////        Это пиздец
//
////        System.out.println(common);
//
//        List allCustomers = this.repository.findAll();
//        log.info("Number of customers: " + allCustomers.size());
//
//        Customer newCustomer = new Customer();
//        newCustomer.setFirstName("John");
//        newCustomer.setLastName(common.getUUID());
//        log.info("Saving new customer...");
//        this.repository.save(newCustomer);
//
//        allCustomers = this.repository.findAll();
//        log.info("Number of customers: " + allCustomers.size());
//        // А это неплохо я придумал
//        allCustomers.stream().map(Object::toString).forEach(s -> log.info("Customers: {}", s));
//
//    }
//
//    @PostMapping(value = "/test")
//    public Id postThrowApi() {
//        Id id = new Id();
//        // Пздц
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Это полный пиздец
//        restTemplate.execute(ebanyUrl, HttpMethod.POST, requestCallback(testService.initNewClient(id)), null);
//
//        id.setUUID("Хуйня: "+ repository.findAll());
//        return id;
//    }
//
//    RequestCallback requestCallback(Common common) {
//        return clientHttpRequest -> {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(clientHttpRequest.getBody(), common);
//            clientHttpRequest.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        };
//    }
//}
//
