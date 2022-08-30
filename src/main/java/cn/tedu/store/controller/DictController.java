package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.DictService;

@Controller
@RequestMapping("dict")
public class DictController {
	@Resource
	private DictService dictService;
	
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr = null;
		List<Province> ps=dictService.getProvinces(); 
		rr = new ResponseResult<List<Province>>(0,"省份列表",ps);
		return rr;
	}
	
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		System.out.println(provinceCode);
		ResponseResult<List<City>> rr  = null;
		List<City> ps=dictService.getCities(provinceCode);
		rr= new ResponseResult<List<City>>(0, "市级", ps);
		return rr;
	}
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		System.out.println(cityCode);
		ResponseResult<List<Area>> rr = null;
		List<Area> ps = dictService.getAreas(cityCode);
		rr= new ResponseResult<List<Area>>(0, "县区", ps);
		return rr;
	}
	
}
