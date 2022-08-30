package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


public class TestPassword {
	public static void testPassword() {
		String password = "lby222222";
		password+=">>>?";
		String paString = DigestUtils.md5Hex(password);
		System.out.println(paString);
	}
	public void testInput()throws IOException {
		InputStream input1 = new FileInputStream("pom.xml");
		//返回文件的消息摘要 返回个16进制的值 数据的指纹 唯一性
		String str1=DigestUtils.md5Hex(input1);
		System.out.println(str1);
		InputStream input2 = new FileInputStream("pom2.xml");
		//返回文件的消息摘要 返回个16进制的值 数据的指纹 唯一性
		String str2=DigestUtils.md5Hex(input2);
		System.out.println(str2);
		System.out.println(str2.equals(str1));
	}
	public static void main(String[] args) throws IOException {
			testPassword();
			
		}
	}
