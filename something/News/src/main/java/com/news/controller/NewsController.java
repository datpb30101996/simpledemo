package com.news.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    @RequestMapping(path = "/hello")
    public String hello() {
        return "Hello News";
    }
}
