package com.urinelab.urinelab.model;

import java.util.HashMap; 
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public record TestResult(String id, String orderId, String findings, String recommendations, String date, String labTechnician) {
    
    public Map<String, AttributeValue> toMap() {
        Map<String, AttributeValue> testResult = new HashMap<>();
        testResult.put("id",  AttributeValue.builder().s(id).build());
        testResult.put("orderId",  AttributeValue.builder().s(orderId).build());
        testResult.put("findings",  AttributeValue.builder().s(findings).build());
        testResult.put("recommendations",  AttributeValue.builder().s(recommendations).build());
        testResult.put("date",  AttributeValue.builder().s(date).build());
        testResult.put("labTechnician",  AttributeValue.builder().s(labTechnician).build());
        return testResult;
    }

}