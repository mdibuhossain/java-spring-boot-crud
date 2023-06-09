package app.web.mdibuhossain.crud.controller;

import app.web.mdibuhossain.crud.dto.RoleToUserFormDTO;
import app.web.mdibuhossain.crud.model.Role;
import app.web.mdibuhossain.crud.model.User;
import app.web.mdibuhossain.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

//    @GetMapping("/role/all")
//    public ResponseEntity<List<Role>> getRoles() {
//        return new ResponseEntity<>(userService.getRoles(), HttpStatus.OK);
//    }

//    @PostMapping("/role/save")
//    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
//        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
//    }

//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserFormDTO roleToUserFormDTO) {
//        userService.addRoleToUser(roleToUserFormDTO.getEmail(), roleToUserFormDTO.getRoleName());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
