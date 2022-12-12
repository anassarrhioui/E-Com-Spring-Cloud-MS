package me.arrhioui.customerservice.entity.projection;

import me.arrhioui.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = {Customer.class})
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
}
