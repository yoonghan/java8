package com.han.stream.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.han.stream.test.entity.*;
import com.han.stream.test.entity.Person.Gender;

public class StreamFunction {

	
	public StreamFunction(){
		List<Person> people = new ArrayList<Person>();
		 
		people.add(new Person("Louise", "Smith", "Dallas", 16000, LocalDate.of(1976, Month.MARCH, 11), Person.Gender.FEMALE));
		people.add(new Person("Tobias", "Jellema", "Hagestein", 4, LocalDate.of(2000, Month.OCTOBER, 30), Person.Gender.MALE));
		people.add(new Person("Mike", "Smith", "Melbourne", 2000, LocalDate.of(1943, Month.NOVEMBER, 1), Person.Gender.MALE));
		people.add(new Person("Mike", "Weber", "Pretoria", 4411, LocalDate.of(1961, Month.DECEMBER, 5), Person.Gender.MALE));
		people.add(new Person("John", "Smith", "London", 9000, LocalDate.of(1975, Month.JANUARY, 11), Person.Gender.MALE));
		people.add(new Person("John", "Williams", "Dublin", 900, LocalDate.of(1985, Month.APRIL, 19), Person.Gender.MALE));
		people.add(new Person("Anna", "Kolokova", "Kiev", 6000, LocalDate.of(1983, Month.JULY, 14), Person.Gender.FEMALE));
		 
		System.out.println(">>>>  List all employees");
		people.forEach(System.out::println);
		
		runGenderSumQuery(people, Person.Gender.FEMALE);
		runGenderSumQuery(people, Person.Gender.MALE);
		
		runNameDistinctQuery(people, Person.Gender.FEMALE);
		runNameDistinctQuery(people, Person.Gender.MALE);
		
		runAgeComparatorQuery(people);
		
		runMapReduce(people);
		
		runGroupingQuery(people);
		
		runMaxMinQuery(people);
	}
	
	private void runMaxMinQuery(List<Person> people) {
		Person pe = people.
		  stream().
		    filter(p -> p.getGender() == Person.Gender.MALE)
		       .max( (p1,p2) -> p1.getAge() - p2.getAge()).get();
		System.out.println("Max:"+pe.getFirstName());
	}

	private void runGroupingQuery(List<Person> people) {
		people.
		  stream().
		    collect(Collectors.groupingBy(Person::getGender)).
		       forEach((g,lp) -> {  System.out.println(" Aggregated age of "+g+" is "
		                                              + lp.stream().mapToInt(p-> p.getAge()).sum());});
	}

	private void runMapReduce(List<Person> people) {
		String reduced = people.
		  stream().
		    filter(p -> p.getGender() == Person.Gender.MALE).
		      map(p -> p.getFirstName()).
		             distinct()
		            .reduce("Distinct First Names ",(name1, name2) -> name1+", "+name2);
		System.out.println(reduced);
		
	}

	private void runAgeComparatorQuery(List<Person> people) {
		Comparator<Person> byAge = Comparator.comparing(Person::getAge);
		people.stream().filter(p -> p.getAge() > 40)
			.sorted(byAge).map(p-> "1:"+p.getFirstName()+" "+p.getLastName())
			.forEach(System.out::println);
		
		people.
		  stream().
		    filter(p -> p.getAge() < 40).
		      sorted((e1, e2) -> e1.getAge() - e2.getAge()).
		        map(p-> "2:"+p.getFirstName()+" "+p.getLastName()).
		          forEach(System.out::println);
	}

	private void runNameDistinctQuery(List<Person> people, Gender gender) {
		Stream<String> peopleName = people.stream().filter(p -> p.getGender() == gender)
							.map(p -> "Name:"+p.getFirstName())
							.distinct();
		peopleName.forEach(System.out::println);		
	}

	private void runGenderSumQuery(List<Person> people, Gender gender) {
		int total = people.stream().filter(p-> p.getGender() == gender)
						.mapToInt(p -> p.getSalary()).sum();
		System.out.println("The gender:"+gender+",total:"+total);
	}

	public static void main(String args[]){
		new StreamFunction();
	}
}
