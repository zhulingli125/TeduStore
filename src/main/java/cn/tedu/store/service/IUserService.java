package cn.tedu.store.service;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 添加用户的方法
	 * @param user 用户对象
	 * @return 成功的行数
	 */
	Integer reg(User user);
	/**
	 * 根据用户名查找对应对象的方法
	 * @param username 用户名
	 * @return 对应的对象
	 */
	User findUserByUsername(String username);
	
	public boolean checkUsername(String username);
	
	public boolean checkEmail(String email);
	
	public boolean checkPhone(String phone);
	/**
	 * 验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	
	/**
	 * 修改密码
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	User getUserById(Integer id);
	void updateImageById(@Param("userid") Integer userid, @Param("image") String image);
	
	void changePerson(Integer id,String username,Integer gender,String phone,String email);
}
