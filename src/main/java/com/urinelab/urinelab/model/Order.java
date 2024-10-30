package com.urinelab.urinelab.model;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

public class Order {
    
    private String id;
    private String date;
    private String customerId;
    private Status status;
    private Address address;

    private Payment payment;
    
    public Order(APIGatewayProxyRequestEvent request) {
        this.id = request.getPathParameters().get("id");;
        this.date = request.getPathParameters().get("date");;
        this.customerId = request.getPathParameters().get("customerId");;
        this.status = Status.valueOf(request.getPathParameters().get("status"));
        
        String[] addressDetail = request.getPathParameters().get("address").split(" ");
        this.address = new Address(addressDetail[0], addressDetail[1], addressDetail[2], Double.valueOf(addressDetail[3]), Double.valueOf(addressDetail[4]));


    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    

}
