package com.hh.eureka.dao.impl;

import com.hh.eureka.dao.OrderDao;
import com.hh.eureka.pojo.Order;
import com.hh.eureka.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 * 三种调用其他服务的方法
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@Repository
public class OrderDaoImpl4Default implements OrderDao {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order getProductByOrderId(String id) {
        return new Order(id, "1111.00", "", connByLoadBalancerAnnotation());
    }

    private List<Product> connByDiscoveryClient() {
        StringBuffer url;
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product");
        if (serviceInstances == null || serviceInstances.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = serviceInstances.get(0);

        url = new StringBuffer("")
                .append("http://")
                .append(serviceInstance.getHost())
                .append(":")
                .append(serviceInstance.getPort())
                .append("/product/getProductList");

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                url.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
                );
        return responseEntity.getBody();
    }

    private List<Product> connByLoadBalanced() {
        StringBuffer url;
        ServiceInstance serviceInstance = loadBalancerClient.choose("product");
        if (serviceInstance == null) {
            return null;
        }

        url = new StringBuffer("")
                .append("http://")
                .append(serviceInstance.getHost())
                .append(":")
                .append(serviceInstance.getPort())
                .append("/product/getProductList");

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                url.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );
        return responseEntity.getBody();
    }

    private List<Product> connByLoadBalancerAnnotation() {
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "http://product/product/getProductList",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );
        return responseEntity.getBody();
    }
}
