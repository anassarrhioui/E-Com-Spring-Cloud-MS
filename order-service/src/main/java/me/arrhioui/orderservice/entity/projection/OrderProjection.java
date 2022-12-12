package me.arrhioui.orderservice.entity.projection;

import me.arrhioui.orderservice.entity.Order;
import me.arrhioui.orderservice.entity.ProductItem;
import me.arrhioui.orderservice.enums.OrderStatus;
import me.arrhioui.orderservice.model.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(types = Order.class, name = "fullOrder")
public interface OrderProjection {

    Long getId();
    Date getCreatedAt();
    OrderStatus getOrderStatus();
    Long getCustomerId();
    Customer getCustomer();
    List<ProductItem> getProducts();
}
