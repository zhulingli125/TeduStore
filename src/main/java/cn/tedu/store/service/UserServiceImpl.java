package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
import cn.tedu.store.service.ex.UsernameNotFoundException;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Value("#{dbConfig.salt}")
	private String salt;
	/**
	 * 1.进行用户名验证
	 * 2.如果用户名不相同，实现插入数据
	 * 3.如果用户名相同，抛出异常
	 * @exception UsernameAlreadyExistException 继承 RuntimeException
	 */
	public Integer reg(User user) {
		User user2=userMapper.findUserByUsername(user.getUsername());
		//用户名不存在
		if(user2==null) {
			System.out.println("用户名不存在，可以注册");
			String pw =user.getPassword();
			pw+=salt;
			pw= DigestUtils.md5Hex(pw);
			user.setPassword(pw);
			return userMapper.insert(user);
			//用户名已存在
		}else {
			throw new UsernameAlreadyExistException("用户名已经存在,请重新输入！");
		}
	}

	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	//如果用户名存在，则返回true，否则，返回false
	public boolean checkUsername(String username) {
		if(userMapper.findUserByUsername(username)==null) {
			return false;
		}else {
			return true;
		}
	}
	//如果邮箱存在，则返回true，否则，返回false
	public boolean checkEmail(String email) {
		return userMapper.getCountByEmail(email)>0;

	}
	//如果电话号码存在，则返回true，否则，返回false
	public boolean checkPhone(String phone) {
		return userMapper.getCountByPhone(phone)>0;
	}

	public User login(String username, String password) {
		System.out.println("login.......");
		User user = userMapper.findUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("用户名不存在");
		}else {
			String rpassword=password+salt;
			rpassword = DigestUtils.md5Hex(rpassword);
			if(rpassword.equals(user.getPassword())) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码输入错误");
			}
		}
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		User user = userMapper.findUserByUserId(id);
		if(user==null) {
			throw new UserNotFoundException("用户不存在");
		}else{
			String roldpassword=oldPassword+salt;
			roldpassword = DigestUtils.md5Hex(roldpassword);
			if(user.getPassword().equals(roldpassword)) {
				String rnewpassword = newPassword+salt;
				rnewpassword = DigestUtils.md5Hex(rnewpassword);
				user.setPassword(rnewpassword);
				userMapper.update(user);
			}else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}
	}

	public void changePerson(Integer id, String username, Integer gender, String phone, String email) {
		User user = userMapper.findUserByUserId(id);
		User user1 = userMapper.findUserByUsername(username); 
		if(user==null) {
			throw new UserNotFoundException("用户不存在");
		}else{
			System.out.println(user);
			if(user1==null) {
				user.setUsername(username);
			}else {
				if(user.getUsername().equals(username)) {

				}else {
					//不能修改数据库中已经有的其他用户名
					throw new UsernameAlreadyExistException("用户名已存在");
				}
			}
			user.setGender(gender);
			user.setPhone(phone);
			user.setEmail(email);
			userMapper.update(user);
		}
	}

	public User getUserById(Integer id) {
		return userMapper.findUserByUserId(id);
	}

	public void updateImageById(Integer userid, String image) {
		userMapper.updateImageById(userid, image);
	}



}
