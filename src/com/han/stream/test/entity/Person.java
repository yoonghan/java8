package com.han.stream.test.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
 
public class Person {
 
    public enum Gender {
   MALE, FEMALE
 }
     
    private String firstName;
    private String lastName;
    private String city;
    private Integer salary;
    private LocalDate dateOfBirth; // = LocalDate.of(2012, Month.MAY, 14) birthDate
    private Gender gender;
 
    public Gender getGender() {
        return gender;
    }
 
    public void setGender(Gender gender) {
        this.gender = gender;
    }
     
    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", city=" + city + ", salary=" + salary + ", dateOfBirth=" + dateOfBirth + '}';
    }    
     
    public Person(String firstName, String lastName, String city, Integer salary, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
 
     
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Integer getAge() {
        LocalDate today = LocalDate.now();
        //Period p = Period.between(this.dateOfBirth, today);
        long p2 = ChronoUnit.YEARS.between(this.dateOfBirth, today);
        return ((Long) p2).intValue();
    }
 
    public Integer getSalary() {
        return salary;
    }
 
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
 
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
}
