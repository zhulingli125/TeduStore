package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.GoodsService;

@Controller
@RequestMapping("goods")
public class GoodsController implements ProductCount {
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/showGoods.do")
	public String showGoods(Integer categoryId,Integer page,Map<String, Object> map) {
		if(page==null) {
			page=1;
		}
		map.put("categoryId", categoryId);
		int offset = (page-1)*ProductCount.COUNT;
		List<Goods> glist=goodsService.getGoodsByCategoryId(categoryId, offset, ProductCount.COUNT);
		map.put("glist", glist);
		for (Goods goods : glist) {
			System.out.println(goods.getCategoryId());
		}
		int count = goodsService.getCount(categoryId);
		map.put("count", count);
		int pageSize  = count%ProductCount.COUNT==0?count/ProductCount.COUNT:count/ProductCount.COUNT+1;
		map.put("pageSize", pageSize);
		map.put("currentPage", page);
		return "search";
	}
	@RequestMapping("/showGoodsByTitle.do")
	public String showGoodsByTitle(String title,Integer page,Map<String, Object> map) {
		if(page==null) {
			page=1;
		}
		int offset = (page-1)*ProductCount.COUNT;
		List<Goods> glist=goodsService.getGoodsByTitle(title, offset, ProductCount.COUNT);
		for (Goods goods : glist) {
			System.out.println(goods.getCategoryId());
		}
		System.out.println(title);
		System.out.println(page);
		map.put("glist", glist);
		map.put("title", title);
		int count = goodsService.getCountByTitle(title);
		map.put("count", count);
		int pageSize  = count%ProductCount.COUNT==0?count/ProductCount.COUNT:count/ProductCount.COUNT+1;
		map.put("pageSize", pageSize);
		map.put("currentPage", page);
		return "search";
	}
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(String id,Map<String, Object> map,Integer categoryId) {
		 Goods goods=goodsService.getGoodsById(id);
		 List<Goods> list = goodsService.getGoodsByCategoryId(categoryId,0,4);
		 map.put("glist", list);
		 map.put("goods", goods);
		 System.out.println(categoryId);
		return "product_details";
	}

	
}
