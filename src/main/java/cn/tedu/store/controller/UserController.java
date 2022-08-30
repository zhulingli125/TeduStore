package cn.tedu.store.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
import cn.tedu.store.service.ex.UsernameNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;

	/**
	 * 显示到注册页面
	 * @return
	 */
	@RequestMapping("/showRegist.do")
	public String showRegister() {
		return "register";

	}
	/**
	 * 显示登录页面
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";

	}
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "password";

	}
	/**
	 * 显示到个人信息页面
	 * @return
	 */
	@RequestMapping("/showPerson.do")
	public String showPerson() {
		return "person";

	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";

	}
	
	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(
			MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException{
		System.out.println("uploadImage");
		ResponseResult<Void> rr = 
				new ResponseResult<Void>(1,"上传成功");
		//获取服务器的真实路径
		String contextPath = session.getServletContext().
				getRealPath("/upload/");
		String path = contextPath+"/"+file.getOriginalFilename();
		System.out.println(path);
		//上传 文件到指定的路径
		file.transferTo(new File(path));
		//修改数据
		userService.updateImageById(
			this.getUid(session),
			"/upload/"+file.getOriginalFilename());
		return rr;
	}
	
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr;
		/*
		 *如果返回true 表示用户名存在
		 *如果返回false 表示用户名不存在
		 */
		if(userService.checkUsername(username)) {
			rr= new ResponseResult<Void>(0,"用户名已经存在");
		}else {
			rr= new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr;
		/*
		 *如果返回true 表示邮箱存在
		 *如果返回false 表示邮箱不存在
		 */
		if(userService.checkEmail(email)) {
			System.out.println(email);
			rr= new ResponseResult<Void>(0,"邮箱已经存在");
		}else {
			System.out.println(email);
			rr= new ResponseResult<Void>(1,"邮箱可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr;
		/*
		 *如果返回true 表示电话存在
		 *如果返回false 表示电话不存在
		 */
		if(userService.checkPhone(phone)) {
			rr= new ResponseResult<Void>(0,"电话号码已经存在");
		}else {
			rr= new ResponseResult<Void>(1,"电话号码可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(String phone,@RequestParam("uname")String username,
			@RequestParam("upwd")String password,String email){
		ResponseResult<Void> rr;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		try {
			userService.reg(user);
			rr= new ResponseResult<Void>(1,"注册成功");
		}catch (UsernameAlreadyExistException e) {
			rr= new ResponseResult<Void>(0,"注册失败");
		}
		return rr;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,
			String password,HttpSession session){
		ResponseResult<Void> rr;
		try {
			User user=userService.login(username, password);
			session.setAttribute("user", user);
			rr= new ResponseResult<Void>(1,"登录成功");
		}catch (UsernameNotFoundException e) {
			rr= new ResponseResult<Void>(0,e.getMessage());
		}catch (PasswordNotMatchException e) {
			rr= new ResponseResult<Void>(-1,e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> UpdatePassword(String newPassword,
			String oldPassword,HttpSession session){
		ResponseResult<Void> rr;
		try {
			Integer id= this.getUid(session);
			userService.changePassword(id,oldPassword, newPassword);
			rr= new ResponseResult<Void>(1,"密码修改成功！");
		}catch (UserNotFoundException e) {
			rr= new ResponseResult<Void>(0,e.getMessage());
		}catch (PasswordNotMatchException e) {
			rr= new ResponseResult<Void>(-1,e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/updatePerson.do")
	@ResponseBody
	public ResponseResult<Void> UpdatePerson(String username, Integer gender, String phone, String email,HttpSession session){
		ResponseResult<Void> rr;
		try {
			System.out.println(username+gender+phone+email);
			Integer id= this.getUid(session);
			userService.changePerson(id, username, gender, phone, email);
			session.setAttribute("user", userService.getUserById(id));
			rr= new ResponseResult<Void>(1,"个人信息修改成功！");
		}catch (UserNotFoundException e) {
			rr= new ResponseResult<Void>(0,e.getMessage());
		}catch (UsernameAlreadyExistException e) {
			rr= new ResponseResult<Void>(-1,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/demo")
	@ResponseBody
	public byte[] demo(HttpServletResponse response) throws IOException {
		response.setContentType("image/png");
		String filename = URLEncoder.encode("图片.png","utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
		byte[] body = getImage();
		return body;
	}
	
	@RequestMapping("/demo2")
	@ResponseBody
	public byte[] demo2(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		String filename = URLEncoder.encode("表格.xlsx","utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
		byte[] body = getExcel();
		return body;
	}
	private static byte[] getExcel() throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("hello");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("helloword!");
		//"酒瓶"用于装byte数据
				ByteArrayOutputStream out=
					new ByteArrayOutputStream();
				workbook.write(out);
				//为"酒瓶"盖上盖子
				workbook.close();
				//从"酒瓶"中倒出byte数据
				byte[] bytes = out.toByteArray();
				return bytes;
	}
	private static byte[] getImage() throws IOException{
		BufferedImage img = 
			new BufferedImage(100, 30, 
			BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		g.setColor(Color.white);
		g.drawString("Hello World", 3, 28);
		//"酒瓶"用于装byte数据
		ByteArrayOutputStream out=
			new ByteArrayOutputStream();
		//将png图片的数据(byte)倒入"酒瓶out"
		ImageIO.write(img, "png", out);
		//为"酒瓶"盖上盖子
		out.close();
		//从"酒瓶"中倒出byte数据
		byte[] bytes = out.toByteArray();
		return bytes;
	}
	
}
