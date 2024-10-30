package com.urinelab.urinelab.model;

import java.util.HashMap; 
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;


public record Address(String streetNumber, String streetName, String surburb, double latitude, double longitude) {

    public String toString() {
        return streetNumber + " " + streetName + " " + surburb;
    }

    public Map<String, AttributeValue> toMap() {
        Map<String, AttributeValue> address = new HashMap<>();
        address.put("streetNumber",  AttributeValue.builder().s(streetNumber).build());
        address.put("streetName",  AttributeValue.builder().s( streetName).build());
        address.put("surburb",  AttributeValue.builder().s( surburb).build());
        address.put("latitude",  AttributeValue.builder().n(String.valueOf(latitude)).build());
        address.put("longitude",  AttributeValue.builder().n(String.valueOf(longitude)).build());
        return address;
    }

}