package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	CartService cartService; 

	@RequestMapping("showCart.do")
	public String showCart(HttpSession session,Map<String, Object> map) {
		int uid = getUid(session);
		List<CartVo> cvList = cartService.selectAll(uid);
		map.put("cvlist", cvList);
		return "cart";
	}
	
	@RequestMapping("deleteById.do")
	public String deleteById(Integer id) {
		cartService.delete(id);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("deleteByBatch.do")
	public String deleteByBatch(Integer [] ids) {
		cartService.deleteByBatch(ids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("updateById.do")
	@ResponseBody
	public ResponseResult<Void> updateById(Integer id,Integer count) {
		cartService.updateById(id, count);
		ResponseResult<Void> rr;
		rr = new ResponseResult<Void>(1, "成功");
		
		return rr;
	}
	
	@RequestMapping("/addCart")
	@ResponseBody
	public ResponseResult<Void> addCart(String goodsid,HttpSession session,Integer count){
		int uid = getUid(session);
		cartService.insert(new Cart(goodsid, uid, count));
		ResponseResult<Void> rr ;
		rr=new ResponseResult<Void>(1, "添加成功");
		return rr;
	}
}
