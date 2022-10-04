package com.myapp.providerservice01.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@Data
@ToString
public class Storage {
    private Integer id;
    private BigDecimal price;
    private Integer count;
}
