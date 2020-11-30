package com.mn.model.dto;

import java.util.ArrayList;
import java.util.List;
 
public class TestFactorySetThread extends Thread {
 
	@Override
	public void run() {
 
		A aSet = BeanFactory.getA();
		
	}
 
	public static void main(String[] args) {
		factoryTest();
	}
	
	private static void factoryTest(){
		Thread t = new Thread(new Runnable(){
 
			public void run() {
				List arrList = new ArrayList();
				for (int i = 0; i < 10; i++) {
					Thread t1 = new TestFactorySetThread();
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