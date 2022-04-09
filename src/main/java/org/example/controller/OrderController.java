package org.example.controller;

import org.example.models.orderApi.ErrorResponse;
import org.example.models.orderApi.OrderRequest;
import org.example.models.orderApi.OrderResponse;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) throws IOException {
      OrderResponse orderResponse = orderService.createOrder(orderRequest);
      return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(RuntimeException exception){
        return new ErrorResponse(exception.getMessage());
    }
}
