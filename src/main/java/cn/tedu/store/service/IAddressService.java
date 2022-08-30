package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	void addAddress(Address address);
	
	List<Address> getAllAddessByUid(Integer uid);
	
	void setDefault(Integer uid,Integer id);
	
	Address getAddressById(Integer id);
	
	void updateAddress(Address address);
	
	void delete(Integer id,Integer uid);
}
