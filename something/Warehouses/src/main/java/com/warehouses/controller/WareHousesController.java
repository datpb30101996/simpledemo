package com.warehouses.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/warehouses")
public class WareHousesController {
    @RequestMapping(path = "/hello")
    public String helloWarehouses() {
        return "Hello Ware Houses";
    }
}
