package com.example.grpcserver;

import com.example.grpc.ProductRequest;
import com.example.grpc.ProductResponse;
import com.example.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void sendProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        // Simulate saving/logging
        System.out.printf("Received product: ID=%s, Name=%s, Price=%.2f%n",
                request.getId(), request.getName(), request.getPrice());

        ProductResponse response = ProductResponse.newBuilder()
                .setMessage("Product received: " + request.getName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
