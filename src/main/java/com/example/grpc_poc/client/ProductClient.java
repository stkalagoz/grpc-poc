package com.example.grpc_poc.client;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductClient<ProductRequest> {

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub stub;

    @EventListener(ApplicationReadyEvent.class)
    public void runClient() {
        ProductRequest request = ProductRequest.newBuilder()
                .setId("1")
                .setName("Monitor")
                .setPrice(250.0)
                .build();

        ProductResponse response = stub.sendProduct(request);
        System.out.println("Client received: " + response.getMessage());
    }
}
