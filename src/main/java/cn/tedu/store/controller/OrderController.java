package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.OrderItemVo;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController extends BaseController {
	@Resource
	private CartService cartService;
	
	@Resource
	private AddressService addressService; 
	
	@Resource
	private OrderService orderService;
	
	@RequestMapping("showOrder.do")
	public String showOrder(HttpSession session,Integer[]ids,Map<String, Object> map) {
		Integer userid =this.getUid(session);
		List<Address> arrList = addressService.getAllAddessByUid(userid);
		List<CartVo> cartList = cartService.selectByUserid(ids, userid);
		map.put("arrList", arrList);
		map.put("cartList", cartList);
		session.setAttribute("cartvoList", cartList);
		return "orderConfirm";
	}
	@RequestMapping("showOrderItem.do")
	public String showOrderItem(HttpSession session,Map<String, Object> map) {
		Integer userid =this.getUid(session);
		List<OrderItemVo> listoiv=orderService.getOrderItem(userid);
		map.put("listoiv", listoiv);
		return "orders";
	}
	@RequestMapping("payment.do")
	public String payment(HttpSession session) {
		int userid= this.getUid(session);
		@SuppressWarnings("unchecked")
		List<CartVo> cartList = (List<CartVo>) session.getAttribute("cartvoList");
		int orderid=orderService.addOrder(userid, cartList);
		session.setAttribute("orderid", orderid);
		return "payment";
	}
	
	@RequestMapping("pay.do")
	public String pay(HttpSession session) {
		int orderid = (Integer) session.getAttribute("orderid");
		orderService.updateStatus(orderid);
		session.removeAttribute("cartvoList");
		session.removeAttribute("orderid");
		return "pay_success";
	}
}
