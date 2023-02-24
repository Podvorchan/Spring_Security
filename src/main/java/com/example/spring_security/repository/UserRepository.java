package com.example.spring_security.repository;

import com.example.spring_security.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findFirstByName(String name);

  boolean existsUserByName(String name);

}
