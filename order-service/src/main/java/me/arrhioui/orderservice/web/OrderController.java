package me.arrhioui.orderservice.web;


import lombok.AllArgsConstructor;
import me.arrhioui.orderservice.entity.Order;
import me.arrhioui.orderservice.model.Customer;
import me.arrhioui.orderservice.model.Product;
import me.arrhioui.orderservice.repository.OrderRepository;
import me.arrhioui.orderservice.repository.ProductItemRepository;
import me.arrhioui.orderservice.rest.CustomerRestClient;
import me.arrhioui.orderservice.rest.InventoryRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private InventoryRestClient inventoryRestClient;

    @GetMapping("/details/orders/{id}")
    public Order fullOrderById(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        long customerId = order.getCustomerId();
        Customer customer = customerRestClient.customerById(customerId);
        order.setCustomer(customer);

        order.getProducts().forEach( productItem -> {
            long productId = productItem.getProductId();
            Product product = inventoryRestClient.productById(productId);
            productItem.setProduct(product);
        });

        return order;
    }
}
