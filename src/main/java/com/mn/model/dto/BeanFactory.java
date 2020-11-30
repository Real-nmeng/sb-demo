package com.mn.model.dto;

public class BeanFactory {
	private static A a = null;
	private static B b = null;
	
	public static synchronized A getAConstructor(){
		if(a == null){
			a = new A(getBConstructor());
		}
		return a;
	}
	
	public static synchronized B getBConstructor(){
		if(b == null){
			b = new B(getAConstructor());
		}
		return b;
	}
	
	public static synchronized A getA(){
		if(a == null){
			a =  new A();
			a.setB(getB());
		}
		return a;
	}
	
	public static synchronized B getB(){
		if(b == null){
			b =  new B();
			b.setA(getA());
		}
		return b;
	}
}