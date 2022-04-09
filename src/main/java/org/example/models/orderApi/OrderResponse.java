package org.example.models.orderApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.models.swapi.PeopleResponse;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long peopleId;
    private PeopleResponse peopleResponse;
    private String orderName;
    private String orderDescription;
}
