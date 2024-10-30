package com.urinelab.urinelab.model;

import java.util.HashMap; 
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public record Payment(String id, String orderId, double amount, PaymentStatus status, String date) {

    public Map<String, AttributeValue> toMap() {
        Map<String, AttributeValue> payment = new HashMap<>();
        payment.put("id",  AttributeValue.builder().s(id).build());
        payment.put("orderId",  AttributeValue.builder().s(orderId).build());
        payment.put("amount",  AttributeValue.builder().n(String.valueOf(amount)).build());
        payment.put("status",  AttributeValue.builder().s(String.valueOf(status)).build());
        payment.put("date",  AttributeValue.builder().s(date).build());
        return payment;
    }
    
}
