package com.loadbalancing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sample")
public class LoadBalancingController {

    @RequestMapping(path = "/hello")
    public String hello() {
        return "hello";
    }
}
