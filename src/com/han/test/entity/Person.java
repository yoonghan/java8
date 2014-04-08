package com.han.test.entity;

import java.util.function.Function;

public class Person {
	private String givenName;
	private String surName;
	private int age;
	
	public Person(Builder builder){
		this.setGivenName(builder.givenName);
		this.setSurName(builder.surName);
		this.setAge(builder.age);
	}

	public static class Builder {
		private String givenName;
		private String surName;
		private int age;
		
		public Builder(){
			
		}

		public Builder givenName(String givenName) {
			this.givenName = givenName;
			return this;
		}

		public Builder surName(String surName) {
			this.surName = surName;
			return this;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
	
	public String toString(){
		return (getGivenName()+"-"+getSurName()+"-"+getAge());
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void printWesternName(){
	   
     System.out.println("Western: \nName: " + this.getGivenName() + "," +this.getSurName() + "\n" +
              "Age: " + this.getAge() + "\n");
   }
     
     
     
   public void printEasternName(){
       
     System.out.println("Eastern: \nName: " + this.getGivenName() + "," +this.getSurName() +   "\n" +
             "Age: " + this.getAge() + "\n");
    }
   
   public String printCustom(Function<Person, String> f){
	   return f.apply(this);
   }

}