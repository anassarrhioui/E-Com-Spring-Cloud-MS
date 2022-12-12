package me.arrhioui.orderservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
