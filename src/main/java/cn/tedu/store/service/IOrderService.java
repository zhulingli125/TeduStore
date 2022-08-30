package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.OrderItemVo;

public interface IOrderService {
	Integer addOrder(Integer userid,List<CartVo> list);
	
	void updateStatus(Integer orderid);
	List<OrderItemVo> getOrderItem(Integer userid);
}
