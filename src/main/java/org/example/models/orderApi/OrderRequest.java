package org.example.models.orderApi;

import lombok.Data;

@Data
public class OrderRequest {
    private Long peopleId;
    private String orderName;
    private String orderDescription;
}
