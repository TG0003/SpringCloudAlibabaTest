package com.myapp.consumerservice01.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@Data
@ToString
public class User {
    private Integer id;
    private BigDecimal balance;
}
