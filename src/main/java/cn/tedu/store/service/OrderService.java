package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.OrderItemVo;
import cn.tedu.store.mapper.OrderMapper;

@Service
public class OrderService implements IOrderService {
	@Resource
	private OrderMapper orderMapper;
	public Integer addOrder(Integer userid, List<CartVo> list) {
		Order order = new Order();
		order.setUserid(userid);
		orderMapper.insertOrder(order);
		for (CartVo cartVo : list) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartVo.getCount());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setImage(cartVo.getImage());
			orderItem.setGoodsid(cartVo.getGoodsid());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setOrderid(order.getId());
			orderItem.setUserid(userid);
			orderMapper.insertOrderItem(orderItem);
		}
		return order.getId();
	}
	public void updateStatus(Integer orderid) {
		orderMapper.updateStatus(orderid);
	}
	public List<OrderItemVo> getOrderItem(Integer userid) {
		return orderMapper.getOrderItem(userid);
	}

}
