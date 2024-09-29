package org.example.dockerdemo.components;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/{name}")
    public String getName(@PathVariable String name) {
        return name;
    }
}
