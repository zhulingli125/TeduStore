package cn.tedu.store.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
    List<GoodsCategory> selectByParentId(@Param("parentId")Integer parentId,
    		@Param("offset")Integer offset,@Param("count")Integer count);
}