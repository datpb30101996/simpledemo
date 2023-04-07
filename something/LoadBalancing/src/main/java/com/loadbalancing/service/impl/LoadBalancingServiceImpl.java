package com.loadbalancing.service.impl;

import com.loadbalancing.service.LoadBalancingService;
import com.loadbalancing.util.Constants;
import com.loadbalancing.util.yml.News;
import com.loadbalancing.util.yml.Warehouses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;
@Service
public class LoadBalancingServiceImpl implements LoadBalancingService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    News news;

    @Autowired
    Warehouses warehouses;

    @Override
    public String process(String iURI) {
        String service = this.getService(iURI);
        if (Constants.SERVICE_NEWS.equals(service)) {
            return this.callNewsService(iURI);
        } else if (Constants.SERVICE_WAREHOUSES.equals(service)) {
            return this.callWarehousesService(iURI);
        }
        return null;
    }

    private String getService(String iURI) {
        String[] arrStr = iURI.split("/");
        return arrStr[1];
    }

    private String callNewsService(String iURI) {
        ResponseEntity<String> response = restTemplate.getForEntity(news.getServer() + iURI, String.class);

        return response.getBody().toString();
    }

    private String callWarehousesService(String iURI) {
        ResponseEntity<String> response = restTemplate.getForEntity(warehouses.getServer() + iURI, String.class);

        return response.getBody().toString();
    }
}
