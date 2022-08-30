package cn.tedu.store.aop;

import org.springframework.stereotype.Component;

@Component
public class TestAop {
	
	public void test() {
		System.out.println("切面方法");
	}
}
