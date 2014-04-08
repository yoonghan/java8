package com.han.test;

public class AnonymousClass {

	public static void main(String args[]){
		Runnable r1 = new Runnable(){
			public void run(){
				System.out.println("Hello world");
			}
		};
		
		Runnable r2 = ()->System.out.println("Hello world 2");
		
		r1.run();
		r2.run();
	}
}
