package io.github.jojomoomaw.JavaSQLPractice.repository;

import io.github.jojomoomaw.JavaSQLPractice.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
