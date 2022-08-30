package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.OrderItemVo;

public interface OrderMapper {
	void insertOrder(Order order);
	
	void insertOrderItem(OrderItem orderItem);
	
	void updateStatus(Integer orderid);
	
	List<OrderItemVo> getOrderItem(Integer userid);
}
