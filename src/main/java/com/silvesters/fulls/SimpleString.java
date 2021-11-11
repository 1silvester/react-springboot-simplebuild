package com.silvesters.fulls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleString {

    @GetMapping("/api/quotes")
    public String getString(){
        return "That which is not good for the swarm, neither is it good for the bee.";
    }
}
