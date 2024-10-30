package com.urinelab.urinelab.util;

import java.util.HashMap;
import java.util.Map;

import com.urinelab.urinelab.model.Order;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class DynamoDBMapper {
    
    public Map<String, AttributeValue> dynamoDBUrineLabItemGenerator(Order order) {
        
        Map<String, AttributeValue> item = new HashMap<>();

        item.put("id", AttributeValue.builder().s(order.getId()).build());
        item.put("date", AttributeValue.builder().s(order.getDate()).build());
        item.put("customerId", AttributeValue.builder().s(order.getCustomerId()).build());
        item.putAll(order.getAddress().toMap());

        return item;
    }

}
