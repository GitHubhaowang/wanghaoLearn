package com.hh.eureka.service.impl;

import com.hh.eureka.pojo.Product;
import com.hh.eureka.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@Service
public class ProductServiceImpl4Default implements ProductService {
    @Override
    public List<Product> getProductList() {
        return new ArrayList<Product>(
                Arrays.asList(
                        new Product("0001", "商品0001", "100.00", "描述0001"),
                        new Product("0002", "商品0002", "200.00", "描述0002"),
                        new Product("0003", "商品0003", "300.00", "描述0003"),
                        new Product("0004", "商品0004", "400.00", "描述0004"),
                        new Product("0005", "商品0005", "500.00", "描述0005"),
                        new Product("0006", "商品0006", "600.00", "描述0006"),
                        new Product("0007", "商品0007", "700.00", "描述0007")
                )
        );
    }
}
