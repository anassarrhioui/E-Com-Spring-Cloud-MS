package me.arrhioui.inventoryservice.repository;

import me.arrhioui.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
