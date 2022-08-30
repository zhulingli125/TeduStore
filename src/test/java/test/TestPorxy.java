package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudent;
import cn.tedu.store.aop.PorxyStudent2;
public class TestPorxy {
	@Test
	public void testProxy() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
		/*IStudent stu = ac.getBean("porxyStudent",IStudent.class);
		stu.add();
		stu.update();*/
		//获取工具类对象
		PorxyStudent2 ps = ac.getBean("porxyStudent2",PorxyStudent2.class);
		//获取动态代理类的对象
		IStudent stu = (IStudent) ps.getObject();
		stu.add();
		stu.update();
		ac.close();
	}
}
