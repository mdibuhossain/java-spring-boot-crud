package app.web.mdibuhossain.crud.repository;

import app.web.mdibuhossain.crud.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
