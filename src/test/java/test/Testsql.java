package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.OrderItemVo;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.controller.UserController;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.DictService;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.IDictService;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserServiceImpl;


public class Testsql {
	@Test
	public void cinsertAll() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		CartService cm = ac.getBean("cartService",CartService.class);
		Integer [] ids = {11,12};
		System.out.println(cm.selectByUserid(ids,3)); 
		ac.close();
	}
	@Test
	public void oinsertAll() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		OrderMapper cm = ac.getBean("orderMapper",OrderMapper.class);
		List<OrderItemVo> list = cm.getOrderItem(3);
		System.out.println(list);
		ac.close();
	}
	@Test
	public void insert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setUsername("zzzzzzz");
		user.setPassword("0.0..");
		user.setPhone("124");
		user.setGender(0);
		user.setEmail("hgjkglyh");
		int i =um.insert(user);
		System.out.println(i);
		ac.close();
	}
	@Test
	public void cinsert() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		Cart cart = new Cart();
		cart.setCount(11);
		cart.setGoodsid("110000042");
		cart.setUserid(12);
		cm.updateCount(cart);
		List<Cart> list = cm.getCartByUserid(3);
		System.out.println(list);
		ac.close();
	}
	
	@Test
	public void fbname() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		um.updateImageById(6, "ghkghgng.jbk");
		ac.close();
	}
	
	@Test 
	public void treg() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		UserServiceImpl usi = ac.getBean("userService",UserServiceImpl.class);
		User user= um.findUserByUsername("35t6");
		int i =usi.reg(user);
		System.out.println(i);
		ac.close();
	}
	@Test 
	public void fid() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		User user= um.findUserByUserId(2);
		System.out.println(user);
		ac.close();
	}
	@Test
	public void tfp() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		int i= um.getCountByEmail("ssss");
		System.out.println(i);
		ac.close();
	}
	
	@Test
	public void tfu() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserServiceImpl usi = ac.getBean("userService",UserServiceImpl.class);
		System.out.println(usi.checkEmail("346993007@qq.com"));
		ac.close();
		
	}
	
	@Test
	public void swewe() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-mvc.xml");
		UserController uc = ac.getBean("userController",UserController.class);
		ResponseResult<Void> rr = uc.checkEmail("346993007@qq.com");
		System.out.println(rr);
		ac.close();
	}
	@Test
	public void user() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-mvc.xml");
		UserServiceImpl usi = ac.getBean("userService",UserServiceImpl.class);
		User user=usi.login("0.0", "0.0");
		System.out.println(user);
		ac.close();
	}
	
	@Test
	public void tupdate() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-mvc.xml");
		IUserService  us = ac.getBean("userService",UserServiceImpl.class);
		us.changePassword(1, "zzz", "0.0");
		ac.close();
	}
	@Test
	public void fdname() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper um = ac.getBean("dictMapper",DictMapper.class);
		List<Province> priv= um.getProvinces();
		System.out.println(priv);
		List<City> lst = um.getCities("110000");
		System.out.println(lst);
		List<Area> lst2 = um.getAreas("110100");
		System.out.println(lst2);
		ac.close();
	}
	
	@Test
	public void dicts() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-mvc.xml");
		IDictService  us = ac.getBean("dictService",DictService.class);
		System.out.println(us.getProvinces());
		System.out.println(us.getCities("110000"));
		System.out.println(us.getAreas("110100"));
		ac.close();
	}
	@Test
	public void rdname() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper im = ac.getBean("addressMapper",AddressMapper.class);
		//im.insert(address);
		System.out.println(im.getAddressbyUid(2).size());
		ac.close();
	}
	@Test
	public void zz() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressService aService= ac.getBean("addressService",AddressService.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("xx");
		address.setRecvProvince("110000");
		address.setRecvCity("110100");
		address.setRecvArea("110101");
		address.setRecvAddr("zzzzz");
		address.setRecvPhone("158425425");
		aService.addAddress(address);
		ac.close();
	}
	
	@Test
	public void zgf() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressService aService= ac.getBean("addressService",AddressService.class);
		aService.updateAddress(aService.getAddressById(5));
		ac.close();
	}
	@Test
	public void zgh() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper im = ac.getBean("addressMapper",AddressMapper.class);
		im.setCancal(3);
		im.setDefault(4);
		ac.close();
	}
	
	@Test
	public void zgu() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper im = ac.getBean("addressMapper",AddressMapper.class);
		Address address = im.getAddressById(5);
		System.out.println(address);
		address.setRecvName("王王");
		address.setRecvProvince("210000");
		address.setRecvCity("210600");
		address.setRecvArea("210628");
		address.setRecvDistrict("晚餐");
		address.setRecvPhone("11111111111");
		im.update(address);
		System.out.println(address);
		ac.close();
	}
	
	@Test
	public void dgf() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressService aService= ac.getBean("addressService",AddressService.class);
		aService.delete(3, 3);
		ac.close();
	}
	@Test
	public void ggh() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		GoodsCategoryService im = ac.getBean("goodsCategoryService",GoodsCategoryService.class);
		List<GoodsCategory> list =im.selectByParentId (186,null,null);
		for(GoodsCategory g : list) {
			System.out.println(g.getName());
		}
		ac.close();
	}
	@Test
	public void dgSf() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		GoodsService im = ac.getBean("goodsService",GoodsService.class);
		List<Goods> list=im.getGoodsByCategoryId(163, 0, 3);
		for (Goods goods : list) {
			System.out.println(goods.getId());
		}
		ac.close();
	}
	@Test
	public void dgSt() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		GoodsMapper im = ac.getBean("goodsMapper",GoodsMapper.class);
		Goods g  = im.getGoodsById("10000044");
		System.out.println(g);
		ac.close();
	}
	
}
