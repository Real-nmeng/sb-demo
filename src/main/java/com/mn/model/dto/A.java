package com.mn.model.dto;

public class A {
	private B b = null; 
 
	public A(){
	}
	
	public A(B b){
		this.b = b;
		System.out.println("print B in A======" + b);
	}
	
	public void setB(B b){
		this.b = b;
		System.out.println("print B in setB======" + b);
	}
	
}