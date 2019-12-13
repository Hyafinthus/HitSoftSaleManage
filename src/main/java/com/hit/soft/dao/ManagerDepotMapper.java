package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.ProductDepot;

@Mapper
public interface ManagerDepotMapper {

	public Integer countQueryProducts(String query);
	
	public List<ProductDepot> queryProducts(@Param("query") String query, @Param("page") Integer page, @Param("limit") Integer limit);
	
	public void turnoverDepot(@Param("depot_name") String depot_name, @Param("product_id") String product_id, @Param("number") String number);

	public void transferDepot(@Param("old_depot") String old_depot, @Param("new_depot") String new_depot, @Param("product_id") String product_id, @Param("number") String number);

}
