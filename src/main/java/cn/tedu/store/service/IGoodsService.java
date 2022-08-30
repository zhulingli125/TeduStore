package cn.tedu.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	   List<Goods> getGoodsByCategoryId(@Param("categoryId")Integer categoryId,
	    		@Param("offset")Integer offset,@Param("count")Integer count);
	   Integer getCount(Integer categoryId);
	   Integer getCountByTitle(String title);
	   Goods getGoodsById(String id);
	   List<Goods> getGoodsByTitle(@Param("title")String title, 
	    		@Param("offset")Integer offset,@Param("count")Integer count);
	   
}
