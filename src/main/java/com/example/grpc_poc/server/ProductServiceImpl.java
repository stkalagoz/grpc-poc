package com.example.grpc_poc.server;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void sendProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        System.out.println("Server received: " + request.getName());

        ProductResponse response = ProductResponse.newBuilder()
                .setMessage("Saved product: " + request.getName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
