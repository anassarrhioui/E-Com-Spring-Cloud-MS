package me.arrhioui.orderservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private Long id;
    private String name;
    private String email;
}
