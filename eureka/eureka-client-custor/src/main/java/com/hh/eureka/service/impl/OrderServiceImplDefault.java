package com.hh.eureka.service.impl;

import com.hh.eureka.dao.OrderDao;
import com.hh.eureka.pojo.Order;
import com.hh.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@Service
public class OrderServiceImplDefault implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order getProductListByOrderId(String id) {
        return orderDao.getProductByOrderId(id);
    }
}
