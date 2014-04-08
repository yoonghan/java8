package com.han.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.han.test.entity.Person;

public class PersonBuilder {
	
	public static List<Person> createShortList(){
		List<Person> people = new ArrayList<>();
		people.add(new Person.Builder()
			.age(11)
			.surName("Mr")
			.givenName("Han").build());
		
		
		people.add(new Person.Builder()
			.age(12)
			.surName("Ms")
			.givenName("Wan").build());
		
		people.add(new Person.Builder()
			.age(24)
			.surName("Ms")
			.givenName("Tan").build());
		
		people.add(new Person.Builder()
			.age(62)
			.surName("Ms")
			.givenName("Ran").build());
			
		people.add(new Person.Builder()
			.age(17)
			.surName("Ms")
			.givenName("San").build());
		
		return people;
	}
	
	public static void main(String[] args) {
		       
		       List<Person> pl = PersonBuilder.createShortList();
		       RoboClass robo = new RoboClass();
		       
		       Predicate<Person> allDriver =  p -> (p.getAge() >=16);
		       
		       System.out.println("\n==== Test 03 ====");
		       System.out.println("\n=== Calling all Drivers ===");
		       robo.callDrivers(pl,allDriver);
		       
		       Predicate<Person> allName =  p -> (p.getAge() >= 18 && p.getAge() <=25);
		       
		       System.out.println("\n=== Emailing all Draftees ===");
		       robo.callName(pl,allName);
		       
		  }
	
}

class RoboClass{
	public void callDrivers(List<Person> pl, Predicate<Person> test){
		for(Person p:pl){
			if(test.test(p)){
				roboCall(p);
			}
		}
	}

	public void callName(List<Person> pl, Predicate<Person> test){
		for(Person p:pl){
			if(test.test(p)){
				roboName(p);
			}
		}
	}
	

	public void roboCall(Person p){
		System.out.println("Calling " + p.getSurName()+ " " + p.getGivenName() + " age " + p.getAge());
	}
	
	public void roboName(Person p){
		System.out.println("Calling " + p.getSurName() + " " + p.getGivenName() + " age " + p.getAge());
	}
}

interface MyTest<T>{
	public boolean test(T t);
}
