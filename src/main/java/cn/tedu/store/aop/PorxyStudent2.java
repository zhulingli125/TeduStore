package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PorxyStudent2 implements InvocationHandler {
	@Autowired
	private Student stu;
	@Autowired
	private TestAop aop;
	//获取代理类的方法
	public Object getObject() {
		return Proxy.newProxyInstance(
				//获取目标类的类加载器
				stu.getClass().getClassLoader()
				//获取目标类的接口信息
				, stu.getClass().getInterfaces(), 
				//实现InvocationHandler的实例对象PorxyStudent2对象
				//stu目标类调用方法的时候回调invoke
				this);
	}
	//回调方法
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		aop.test();
		//反射实例化stu对象
		Object obj=method.invoke(stu, args);
		return obj;
	}
	
	
	
}
