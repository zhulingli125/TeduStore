package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 添加用户的方法
	 * @param user 用户对象
	 * @return 成功的行数
	 */
	Integer insert(User user);
	/**
	 * 根据用户名查找对应对象的方法
	 * @param username 用户名
	 * @return 对应的对象
	 */
	User findUserByUsername(String username);
	/**
	 * 根据id查找对应对象的方法
	 * @param id
	 * @return 对应的对象
	 */
	User findUserByUserId(Integer id);
	/**
	 * 根据email查询，如果存在返回非0，
	 * 不存在返回0
	 * @param email
	 * @return
	 */
	Integer getCountByEmail(String email);
	
	/**
	 * 根据phone查询，如果存在返回非0，
	 * 不存在返回0
	 * @param email
	 * @return
	 */
	Integer getCountByPhone(String phone);

	void update(User user);
	
	void updateImageById(@Param("userid") Integer userid, @Param("image") String image);
	
	
}
