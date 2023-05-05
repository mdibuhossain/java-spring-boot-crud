package app.web.mdibuhossain.crud.service;

import app.web.mdibuhossain.crud.model.Role;
import app.web.mdibuhossain.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);

    Optional<User> getUser(String email);

    List<User> getUsers();

    List<Role> getRoles();
}
