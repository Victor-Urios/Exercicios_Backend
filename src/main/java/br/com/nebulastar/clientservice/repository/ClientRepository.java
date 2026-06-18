package br.com.nebulastar.clientservice.repository;

import br.com.nebulastar.clientservice.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Nebula Stardust
 */
public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findByDocument(String document);

    @Query("{ '$or': [ " +
            "{ 'name': { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'email': { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'document': { '$regex': ?0, '$options': 'i' } } " +
            "] }")
    List<Client> search(String term);
}
