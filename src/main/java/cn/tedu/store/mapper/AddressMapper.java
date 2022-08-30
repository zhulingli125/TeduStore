package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {

	void insert(Address address);
	
	List<Address> getAddressbyUid(Integer uid);
	
	void setCancal(Integer uid);
	
	void setDefault(Integer id);
	
	Address getAddressById(Integer id);
	
	void update(Address address);
	
	Integer delete(Integer id);
}
