package me.arrhioui.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.arrhioui.orderservice.enums.OrderStatus;
import me.arrhioui.orderservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> products;

}
