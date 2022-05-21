package com.impl.vk.controller;

import com.api.dto.requestDto.Id;
import com.api.dto.responseDto.Common;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impl.vk.service.CreateClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

@RestController
@Data
public class ControllerTest {
    @Autowired
    private CreateClientService testService;

    @PostMapping(value = "/vk/api")
    public void testToApi(@RequestBody Common common) {
        System.out.println(common);
    }

    @PostMapping(value = "/test")
    public Common postThrowApi() {
        Id id = new Id();
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.execute("http://localhost:8080/vk/api",  HttpMethod.POST,
                requestCallback(testService.initNewClient(id)),
                null);

        id.setUUID("suka");
       return testService.initNewClient(id);
    }

    RequestCallback requestCallback(Common common) {
        return clientHttpRequest -> {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(clientHttpRequest.getBody(), common);
            clientHttpRequest.getHeaders().add(
                    HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        };
    }
}

