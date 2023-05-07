package app.web.mdibuhossain.crud.controller;

import app.web.mdibuhossain.crud.dto.AuthRequestDTO;
import app.web.mdibuhossain.crud.dto.AuthResponseDTO;
import app.web.mdibuhossain.crud.dto.RegisterRequestDTO;
import app.web.mdibuhossain.crud.service.AuthService;
import app.web.mdibuhossain.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO registerRequestDTO
    ) {
        return ResponseEntity.ok(authService.register(registerRequestDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(
            @RequestBody AuthRequestDTO authRequestDTO
    ) {
        return ResponseEntity.ok(authService.authenticate(authRequestDTO));
    }
}
