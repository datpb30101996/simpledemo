package com.loadbalancing.service.impl;

import com.loadbalancing.service.LoadBalancingService;
import com.loadbalancing.util.Constants;
import com.loadbalancing.util.yml.News;
import com.loadbalancing.util.yml.Warehouses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

public class LoadBalancingServiceImpl implements LoadBalancingService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    News news;

    @Autowired
    Warehouses warehouses;

    @Autowired
    HttpHeaders headers;

    @Override
    public String process(String iURI) {
        String service = this.getService(iURI);
        if (Constants.SERVICE_NEWS.equals(service)) {
            
        } else if (Constants.SERVICE_WAREHOUSES.equals(service)) {

        }
        return null;
    }

    private String getService(String iURI) {
        String[] arrStr = iURI.split("/");
        return arrStr[0];
    }

    private String callNewsService(String iURI) {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                news.getServer() + "iURI", HttpMethod.GET, entity, String.class).getBody();
    }

    private String callWarehousesService(String iURI) {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                warehouses.getServer() + "iURI", HttpMethod.GET, entity, String.class).getBody();
    }
}
