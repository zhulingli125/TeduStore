package cn.tedu.store.aop;

import org.springframework.stereotype.Component;

@Component
public class Student implements IStudent {

	public void add() {
		System.out.println("添加数据");
	}

	public void update() {
		System.out.println("修改数据");
	}

}
