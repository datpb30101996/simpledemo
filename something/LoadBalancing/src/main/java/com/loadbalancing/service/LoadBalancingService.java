package com.loadbalancing.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface LoadBalancingService {
    public String process(String iURI);
}
