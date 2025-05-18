
package com.example.grpserver.service;

import com.example.grpc.ProductServiceGrpc;
import com.example.grpc.ProductRequest;
import com.example.grpc.ProductResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void sendProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        String name = request.getName();
        double price = request.getPrice();

        System.out.println("Received product: " + name + " - $" + price);

        ProductResponse response = ProductResponse.newBuilder()
                .setStatus("Product received: " + name)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
