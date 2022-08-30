package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService {

	@Resource
	private DictMapper dictMapper;
	
	@Resource
	private AddressMapper  addressMapper;
	
	public void addAddress(Address address) {
		String pCode = address.getRecvProvince();
		String pname = dictMapper.getProvinceByCode(pCode);
		String cCode = address.getRecvCity();
		String cName = dictMapper.getCityByCode(cCode);
		String aCode = address.getRecvArea();
		String aName = dictMapper.getAreaByCode(aCode);
		address.setRecvDistrict(pname+cName+aName);
		int i =addressMapper.getAddressbyUid(address.getUid()).size();
		if(i>0) { //0代表之前有数据
			address.setIsDefault(0);
			addressMapper.insert(address);
		}else {	//1代表第一次添加地址
			address.setIsDefault(1);
			addressMapper.insert(address);
		}
	}

	public List<Address> getAllAddessByUid(Integer uid) {
		// TODO Auto-generated method stub
		return addressMapper.getAddressbyUid(uid);
	}

	public void setDefault(Integer uid, Integer id) {
		addressMapper.setCancal(uid);
		addressMapper.setDefault(id);
	}

	public Address getAddressById(Integer id) {
		return addressMapper.getAddressById(id);
	}
	
	
	public void updateAddress(Address address) {
		String  pName = dictMapper.getProvinceByCode(address.getRecvProvince());
		String cName = dictMapper.getCityByCode(address.getRecvCity());
		String aName  =dictMapper.getAreaByCode(address.getRecvArea());
		address.setRecvDistrict(pName+cName+aName);
		addressMapper.update(address);
	}


	public void delete(Integer id, Integer uid) {
		Address address=addressMapper.getAddressById(id);
		Integer count = addressMapper.delete(id);
		if(count == 1) {
			if(address.getIsDefault()==1) {
				List<Address> list=addressMapper.getAddressbyUid(uid);
				if(list.size()>0) {
					Address naddress=list.get(0);
					int nid = naddress.getId();
					addressMapper.setDefault(nid);
				}
			}
		}
	}
	
	
 
}
