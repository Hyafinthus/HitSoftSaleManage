package com.hit.soft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hit.soft.domain.ProductDepot;

@Mapper
public interface ManagerDepotMapper {

	public Integer countQueryProducts(String query);
	
	public List<ProductDepot> queryProducts(@Param("query") String query, @Param("page") Integer page, @Param("limit") Integer limit);
	
	// 以下为进货相关
	// 查询某货品两个仓库总量
	public Integer countProductDepot(Integer product_id);
	
	// 查询某货品当前进价
	public Double queryProductPurchase(Integer product_id);
	
	// 更新某货品进价
	public void updateProductPurchase(@Param("product_id") Integer product_id, @Param("purchase_price") Double purchase_price);
	
	// 更新某仓库某货品数量 (进出货通用)
	public void turnoverDepot(@Param("depot_name") String depot_name, @Param("product_id") Integer product_id, @Param("number") Integer number);

	public void transferOldDepot(@Param("old_depot") String old_depot, @Param("product_id") Integer product_id, @Param("number") Integer number);

	public void transferNewDepot(@Param("new_depot") String new_depot, @Param("product_id") Integer product_id, @Param("number") Integer number);

	public Integer countQueryDepot(String depot_name);
	
	public List<ProductDepot> queryDepot(@Param("depot_name") String depot_name, @Param("page") Integer page, @Param("limit") Integer limit);

	public void confirmDepot(@Param("depot_name") String depot_name, @Param("product_id") Integer product_id, @Param("number") Integer number);
	
}
