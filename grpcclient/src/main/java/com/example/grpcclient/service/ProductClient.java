package com.example.grpcclient.service;

import com.example.grpc.ProductRequest;
import com.example.grpc.ProductResponse;
import com.example.grpc.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ProductClient {

    @GrpcClient("productService")
    private ProductServiceGrpc.ProductServiceBlockingStub productStub;

    public void sendProduct(String name, double price) {
        ProductRequest request = ProductRequest.newBuilder()
                .setName(name)
                .setPrice(price)
                .build();

        ProductResponse response = productStub.sendProduct(request);
        System.out.println("Response from gRPC Server: " + response.getStatus());
    }
}
