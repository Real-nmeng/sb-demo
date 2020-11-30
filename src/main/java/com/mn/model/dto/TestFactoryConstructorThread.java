package com.mn.model.dto;

import java.util.ArrayList;
import java.util.List;
 
public class TestFactoryConstructorThread extends Thread {
 
	@Override
	public void run() {		
		A aConstructor = BeanFactory.getAConstructor();
	}
 
	public static void main(String[] args) {
		factoryTest();
	}
	
	private static void factoryTest(){
		Thread t = new Thread(new Runnable(){
 
			public void run() {
				List arrList = new ArrayList();
				for (int i = 0; i < 10; i++) {
					Thread t1 = new TestFactoryConstructorThread();
					t1.setDaemon(true);
					arrList.add(t1);
				}
				
				for (int i = 0; i < arrList.size(); i++) {
					Thread t1 = (Thread) arrList.get(i);
					t1.start();
				}
				
			}});
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}