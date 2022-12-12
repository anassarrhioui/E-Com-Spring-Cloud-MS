package me.arrhioui.orderservice;

import me.arrhioui.orderservice.entity.Order;
import me.arrhioui.orderservice.entity.ProductItem;
import me.arrhioui.orderservice.enums.OrderStatus;
import me.arrhioui.orderservice.model.Customer;
import me.arrhioui.orderservice.model.Product;
import me.arrhioui.orderservice.repository.OrderRepository;
import me.arrhioui.orderservice.repository.ProductItemRepository;
import me.arrhioui.orderservice.rest.CustomerRestClient;
import me.arrhioui.orderservice.rest.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            InventoryRestClient inventoryRestClient
    ) {

        return args -> {
            List<Customer> customers = new ArrayList<>(customerRestClient.allCustomers().getContent());
            List<Product> products = new ArrayList<>(inventoryRestClient.allProducts().getContent());
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                Order order = Order
                        .builder()
                        .customerId(customers.get(random.nextInt(customers.size())).getId())
                        .orderStatus(Math.random() > .5 ? OrderStatus.PENDING : OrderStatus.DELIVERED)
                        .createdAt(new Date())
                        .build();

                Order savedOrder = orderRepository.save(order);

                for (Product product : products) {
                    if (Math.random() > .7) {
                        ProductItem productItem = ProductItem
                                .builder()
                                .productId(product.getId())
                                .order(savedOrder)
                                .discount(Math.random() < .1 ? .2 : 0)
                                .quantity(random.nextInt(10) + 1)
                                .totalPrice(Math.random() * 10000)
                                .build();
                        productItemRepository.save(productItem);
                    }
                }
            }
        };
    }
}
