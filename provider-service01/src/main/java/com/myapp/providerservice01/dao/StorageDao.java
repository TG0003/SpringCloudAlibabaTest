package com.myapp.providerservice01.dao;

import com.myapp.providerservice01.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    Storage findStorageById(Integer id);
    Integer deductStorage(@Param("id") Integer id, @Param("count")Integer count);
}
