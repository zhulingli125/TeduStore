package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	
	/*@Before("bean(userService)")
	public void test1() {
		System.out.println("方法开始执行");
	}*/
	
	@After("bean(userService)")
	public void test2() {
		System.out.println("结束");
	}
	
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("无异常方法执行！！！");
	}
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("发生异常方法执行！！！");
	}
	
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("环绕通知，方法执行之前..");
		long start = System.currentTimeMillis();
		Object obj=jp.proceed();//调用业务方法
		System.out.println("环绕通知，方法执行之后..");
		long end =System.currentTimeMillis();
		System.out.println(end-start+"毫秒");
		return obj;
	}
	
	/*@Before("within(cn.tedu.store.service.*Service)")
	public void test6() {
		System.out.println("基于类切点的配置");
	}*/
	/*
	 * '*' 方法的返回值
	 *‘..’方法的参数列表
	 */
	@Before("execution(* cn.tedu.store.service.IUserService.login(..))")
	public void test7() {
		System.out.println("基于方法切点的配置");
	}
}
