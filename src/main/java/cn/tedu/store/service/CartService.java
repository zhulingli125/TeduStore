package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;

@Service
public class CartService implements ICartService {
	@Resource
	private CartMapper cartMapper;
	
	public void insert(Cart cart) {
		List<Cart> list = cartMapper.getCartByUserid(cart.getUserid());
		for (Cart cart2 : list) {
			/*
			 * 这里注意条件判断为false时，不能直接写在else块里
			 * 例如第一个条件就是false，后面的对象就判断不了了
			 * 因此遍历对象直到为条件true时，执行完代码块后return, 表示整个方法结束
			 * 当所有对象都遍历完了之后遍历结束，执行遍历后面的代码
			 */
			if(cart.getGoodsid().equals(cart2.getGoodsid())) {
				Integer quett =  cart.getCount()+cart2.getCount();
				cart.setCount(quett);
				cartMapper.updateCount(cart);
				return;//方法结束
			}
		}
			cartMapper.insert(cart);
	}

	public List<CartVo> selectAll(Integer userid) {
		return cartMapper.selectAll(userid);
	}

	public void delete(Integer id) {
		cartMapper.delete(id);
	}

	public void deleteByBatch(Integer[] ids) {
		cartMapper.deleteByBatch(ids);
	}

	public void updateById(Integer id, Integer count) {
		cartMapper.updateById(id, count);
		
	}

	public List<CartVo> selectByUserid(Integer[] ids, Integer userid) {
		List<CartVo> list=cartMapper.selectAll(userid);
		List<CartVo> nlist= new ArrayList<CartVo>();
		for (CartVo cartVo : list) {
			for (Integer id : ids) {
				if(cartVo.getCartId()==id) {
					nlist.add(cartVo);
					break;
				}
			}
		}
		return nlist;
	}
}
