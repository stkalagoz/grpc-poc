package com.example.grpcclient;

import com.example.grpcclient.service.ProductClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GrpcclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcclientApplication.class, args);
	}


	@Component
	public class Runner implements CommandLineRunner {

		private final ProductClient client;

		public Runner(ProductClient client) {
			this.client = client;
		}

		@Override
		public void run(String... args) throws Exception {
			client.sendProduct("Laptop", 1500.0);
		}
	}

}
