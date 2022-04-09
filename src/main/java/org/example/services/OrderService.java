package org.example.services;

import org.example.models.orderApi.OrderRequest;
import org.example.models.orderApi.OrderResponse;
import org.example.models.swapi.PeopleResponse;
import org.example.clients.SwapiServiceClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderService {
    private static SwapiServiceClient.SwapiService swapiService = SwapiServiceClient.createSwapiService();
    public OrderResponse createOrder(OrderRequest orderRequest) throws IOException {
        PeopleResponse peopleResponse = swapiService.getPeople(orderRequest.getPeopleId()).execute().body();
        if(peopleResponse.getName().equals("Darth Vader")) throw new RuntimeException("Darth Vader cannot create an order.");
        return new OrderResponse(1L, orderRequest.getPeopleId() ,peopleResponse, orderRequest.getOrderName(), orderRequest.getOrderDescription());
    }
}
