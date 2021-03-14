package com.hh.eureka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class Product implements Serializable {
    private String id;
    private String name;
    private String price;
    private String desc;
}
