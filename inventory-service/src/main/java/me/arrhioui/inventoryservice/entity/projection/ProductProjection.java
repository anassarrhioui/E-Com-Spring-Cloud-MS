package me.arrhioui.inventoryservice.entity.projection;

import me.arrhioui.inventoryservice.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct", types = {Product.class})
public interface ProductProjection {
    Long getId();
    String getName();
    double getPrice();
    int getQuantity();
}
