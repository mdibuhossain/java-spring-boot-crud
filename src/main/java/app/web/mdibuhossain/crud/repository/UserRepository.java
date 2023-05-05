package app.web.mdibuhossain.crud.repository;

import app.web.mdibuhossain.crud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
