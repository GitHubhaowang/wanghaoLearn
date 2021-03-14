package com.hh.eureka.service;

import com.hh.eureka.pojo.Order;
import com.hh.eureka.pojo.Product;

import java.util.List;

public interface OrderService {
    public Order getProductListByOrderId(String id);
}
