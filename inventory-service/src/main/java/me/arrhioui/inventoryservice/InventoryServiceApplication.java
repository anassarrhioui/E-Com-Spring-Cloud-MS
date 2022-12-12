package me.arrhioui.inventoryservice;

import me.arrhioui.inventoryservice.entity.Product;
import me.arrhioui.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {
        return args -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                productRepository.save(
                        Product
                                .builder()
                                .name("Product " + i)
                                .quantity(random.nextInt(300) + 1)
                                .price(Math.random() * 10000)
                                .build()
                );
            }
        };
    }

}
