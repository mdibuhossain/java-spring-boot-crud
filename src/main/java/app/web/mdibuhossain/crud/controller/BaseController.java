package app.web.mdibuhossain.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BaseController {
    @GetMapping({"/", ""})
    public String helloAPI() {
        return "Welcome to the API end point";
    }
}
