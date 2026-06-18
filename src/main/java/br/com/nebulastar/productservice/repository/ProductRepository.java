package br.com.nebulastar.productservice.repository;

import br.com.nebulastar.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
/**
 * 
 * @author Nebula Stardust
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findBySku(String sku);


    List<Product> findByCategory(String category);

    @Query("{ '$or': [ " +
            "{ 'name': { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'description': { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'sku': { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'category': { '$regex': ?0, '$options': 'i' } } " +
            "] }")
    List<Product> search(String term);
}
