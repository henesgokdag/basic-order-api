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
        if(orderRequest.getPeopleId().equals(4L)) throw new RuntimeException("Darth Vader cannot create an order.");
        PeopleResponse peopleResponse = swapiService.getPeople(orderRequest.getPeopleId()).execute().body();
        return new OrderResponse(1L, peopleResponse, orderRequest.getOrderName(), orderRequest.getOrderDescription());
    }
}
