package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	void insert(Cart cart);
	
	List<Cart> getCartByUserid(Integer userid);
	
	void updateCount(Cart cart);
	
	List<CartVo> selectAll(Integer userid);
	
	void delete(Integer id);
	
	void deleteByBatch(Integer [] ids);
	
	void updateById(@Param("id") Integer id,@Param("count") Integer count);
	
}
