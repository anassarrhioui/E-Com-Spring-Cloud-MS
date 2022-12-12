package me.arrhioui.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.arrhioui.orderservice.model.Product;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @Transient
    private Product product;
    private double totalPrice;
    private int quantity;
    private double discount;
    @ManyToOne
    @JsonIgnore
    private Order order;
}
