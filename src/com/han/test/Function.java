package com.han.test;

import java.util.List;
import com.han.test.entity.Person;

public class Function {
	public static void main(String args[]){
		List<Person> persons = PersonBuilder.createShortList();
		
		for(Person person: persons){
			System.out.println(
					person.printCustom(p->p.getGivenName()+","+p.getSurName()+"\n"
							+"Age:"+p.getAge())
			);
		}
	}
}
