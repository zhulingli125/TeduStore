package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.GoodsService;


@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private GoodsCategoryService gcs;
	
	@Resource
	private GoodsService gs;
	
	@RequestMapping("/showIndex.do")
	public String  showIndex(Map<String, Object> map) {
		List<GoodsCategory> list1 = gcs.selectByParentId(161, 0, 3);
		List<List<GoodsCategory>> list2= new ArrayList<List<GoodsCategory>>();
		for (GoodsCategory g : list1) {
			int i =  g.getId();
			list2.add(gcs.selectByParentId(i, null, null));
		}
		map.put("list1",list1);
		map.put("list2",list2);
		List<Goods> glist = gs.getGoodsByCategoryId(163,0,3);
		map.put("glist",glist);
		return "index";
	}
	
}
