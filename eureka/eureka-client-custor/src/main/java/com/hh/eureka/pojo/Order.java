package com.hh.eureka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String totalPrice;
    private String desc;
    private List<Product> products;
}
