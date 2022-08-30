package cn.tedu.store.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
    List<Goods> getGoodsByCategoryId(@Param("categoryId")Integer categoryId,
    		@Param("offset")Integer offset,@Param("count")Integer count);
   
    Integer getCount(Integer categoryId);
    
    Goods getGoodsById(String id);
    
    Integer getCountByTitle(String title);
    	
    List<Goods> getGoodsByTitle(@Param("title")String title, 
    		@Param("offset")Integer offset,@Param("count")Integer count);
    
}