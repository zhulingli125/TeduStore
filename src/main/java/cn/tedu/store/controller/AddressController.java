package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private AddressService addressService; 
	
	@RequestMapping("/add.do")
	public String add(
			HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			) {
		int uid = this.getUid(session);
		Address address = new Address();
		address.setUid(uid);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvZip(recvZip);
		address.setRecvTel(recvTel);
		address.setRecvArea(recvArea);
		address.setRecvTag(recvTag);
		System.out.println(recvProvince);
		System.out.println(address);
		addressService.addAddress(address);
		return "redirect:../address/showAddress.do";
	}
	
	@RequestMapping("/showAddress.do")
	public String getAllAddessByUid(HttpSession session,Map<String,List<Address>> map) {
		int uid = this.getUid(session);
		List<Address> aList=addressService.getAllAddessByUid(uid);
		for(Address address :aList) {
			System.out.println(address);
		}
		map.put("listAddress", aList);
		return "addressAdmin";
	}
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id,HttpSession session) {
		Integer uid = this.getUid(session);
		addressService.setDefault(uid, id);
		return "redirect:../address/showAddress.do";
	}
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<Address> getAddress(Integer id) {
		Address address=addressService.getAddressById(id);
		ResponseResult<Address> rr = new ResponseResult<Address>(1, "成功", address);
		return rr;
	}
	@RequestMapping("/updateAddress.do")
	public String updateAddress(
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag,
			Integer id
			) {
		Address address = addressService.getAddressById(id);
		System.out.println(address);
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvZip(recvZip);
		address.setRecvTel(recvTel);
		address.setRecvArea(recvArea);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		System.out.println(address);
		return "redirect:../address/showAddress.do";
	}
	@RequestMapping("/deleteAddress.do")
	public String deleteAddress(Integer id,HttpSession session) {
			addressService.delete(id,this.getUid(session));
			return "redirect:../address/showAddress.do";
		}
}
