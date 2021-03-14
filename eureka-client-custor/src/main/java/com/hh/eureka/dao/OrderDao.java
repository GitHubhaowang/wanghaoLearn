package com.hh.eureka.dao;

import com.hh.eureka.pojo.Order;
import com.hh.eureka.pojo.Product;

import java.util.List;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
public interface OrderDao {
    public Order getProductByOrderId(String id);
}
