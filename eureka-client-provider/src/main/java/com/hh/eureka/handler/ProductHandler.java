package com.hh.eureka.handler;

import com.hh.eureka.pojo.Product;
import com.hh.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@RestController
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "getProductList")
    public List<Product> getProductList() {
        return productService.getProductList();
    }
}
