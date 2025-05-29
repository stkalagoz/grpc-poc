package com.example.grpcclient.config;

import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

@Configuration
public class GrpcClientConfig {

    //test1

    @Bean
    public GrpcChannelConfigurer trustCertsConfigurer() {
        return (channelBuilder, name) -> {
            try {
                File certFile = new ClassPathResource("certs/ca.crt").getFile();
                SslContext sslContext = GrpcSslContexts.forClient()
                        .trustManager(certFile)
                        .build();
                ((NettyChannelBuilder) channelBuilder).sslContext(sslContext);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load TLS cert", e);
            }
        };
    }
}
