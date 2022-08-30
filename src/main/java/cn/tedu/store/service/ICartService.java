package cn.tedu.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface ICartService {
	void insert(Cart cart);
	
	List<CartVo> selectAll(Integer userid);
	
	void delete(Integer id);
	
	void deleteByBatch(Integer [] ids);
	
	void updateById(@Param("id") Integer id,@Param("count") Integer count);
	
	List<CartVo> selectByUserid(@Param("ids")Integer[] ids,@Param("userid")Integer userid);
}
