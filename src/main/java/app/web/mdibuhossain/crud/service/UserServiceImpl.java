package app.web.mdibuhossain.crud.service;

import app.web.mdibuhossain.crud.model.Role;
import app.web.mdibuhossain.crud.model.User;
import app.web.mdibuhossain.crud.repository.RoleRepository;
import app.web.mdibuhossain.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Optional<User> user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.ifPresent(updateUser -> {
            updateUser.addRole(role);
            userRepository.save(updateUser);
        });
    }

    @Override
    public Optional<User> getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> getRoles() {
        ;
        return roleRepository.findAll();
    }
}
