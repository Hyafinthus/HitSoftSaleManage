package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.Product;

@Mapper
public interface ManagerProfileMapper {
	
	public Integer countQueryProducts(String query);
	
	public List<Product> queryProducts(@Param("query") String query, @Param("page") Integer page, @Param("limit") Integer limit);
	
}
