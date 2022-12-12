package me.arrhioui.orderservice.repository;

import me.arrhioui.orderservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
