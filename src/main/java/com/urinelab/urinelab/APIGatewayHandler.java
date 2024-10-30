package com.urinelab.urinelab;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.urinelab.urinelab.model.Order;
import com.urinelab.urinelab.util.DynamoDBMapper;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public class APIGatewayHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final DynamoDbClient dynamoDbClient;

    public APIGatewayHandler() {
        this.dynamoDbClient = DynamoDbClient.builder()
                .region(Region.AF_SOUTH_1)
                .build();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        //Extract to builder class
        Order order = new Order(request);

        //Extract to map class
        Map<String, AttributeValue> item = new DynamoDBMapper().dynamoDBUrineLabItemGenerator(order);
        

        //Extract dynamodb class
        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName("UrineLabConnect") 
                .item(item)
                .build();

        dynamoDbClient.putItem(putItemRequest);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setBody("Item added successfully");

        return response;
    }
}
