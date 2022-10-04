package com.myapp.consumerservice01.dao;

import com.myapp.consumerservice01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: 18061
 * @date: 2022/10/2
 */
@Mapper
public interface UserDao {
    User findUserById(Integer id);
    Integer deductBalance(@Param("id") Integer id, @Param("balance") BigDecimal balance);
}
