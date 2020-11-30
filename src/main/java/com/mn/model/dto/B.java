package com.mn.model.dto;

public class B {
	private A a = null;
 
	public B(){
	}
	
	public B(A a) {
		this.a = a;
		System.out.println("print A in B======" + a);
	}
 
	public void setA(A a) {
		this.a = a;
		System.out.println("print A in setA======" + a);
	}
	
}