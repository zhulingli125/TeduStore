package cn.tedu.store.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PorxyStudent implements IStudent {
	@Autowired
	private Student stu;
	@Autowired
	private TestAop aop;
	public void add() {
		aop.test();
		stu.add();
	}
	public void update() {
		stu.update();
		aop.test();
		
	}
	
	
}
