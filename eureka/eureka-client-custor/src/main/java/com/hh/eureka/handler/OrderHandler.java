package com.hh.eureka.handler;

import com.hh.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String getOrder() {
        return orderService.getProductListByOrderId("0001").toString();
    }
}
