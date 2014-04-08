package com.han.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionClass {

	public CollectionClass(){
		
		List<Person> personList = Person.createShortList();
		
		Collections.sort(personList, new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p2.getOrder() - p1.getOrder();
			}
		});
	
	
		for(Person person: personList){
			System.out.println(">>"+person.getName());
		}
		
		
		Collections.sort(personList, (p1,p2)-> p2.getOrder() - p1.getOrder());
		
		for(Person person: personList){
			System.out.println(">>"+person.getName());
		}
		
	}
	
	public static void main(String args[]){
		new CollectionClass();
	}
}

class Person{
	private String name;
	private int age;
	private int order;
	
	public Person(String name, int age, int order){
		this.name=name;
		this.age=age;
		this.order=order;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public static List<Person> createShortList(){
		ArrayList<Person> list = new ArrayList<Person>(5);
		Person p1 = new Person("Han",11,1);
		Person p2 = new Person("Alice",41,2);
		Person p3 = new Person("Bobo",15,3);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		return list;
	}
	
}

class MethodsInComparator implements Comparator<Object>{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
