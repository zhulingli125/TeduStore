package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
@Service
public class GoodsService implements IGoodsService{
	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}

	public Integer getCount(Integer categoryId) {
		return goodsMapper.getCount(categoryId);
	}

	public List<Goods> getGoodsByTitle(String title, Integer offset, Integer count) {
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}

	public Integer getCountByTitle(String title) {
		// TODO Auto-generated method stub
		return goodsMapper.getCountByTitle(title);
	}

	public Goods getGoodsById(String id) {
		return goodsMapper.getGoodsById(id);
	}

}
