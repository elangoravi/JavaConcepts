/*
Design: Builder pattern (tightly coupled with Immutable.java)
Description:  The builder pattern is a creational pattern in which parameters are passed to a builder object, often through method chaining, and an object is generated with a final build call. 
It is often used with immutable objects, since immutable objects do not have setter methods and must be created with all of their parameters set, 
although it can be used with mutable objects as well. 

Motivation:
 As our data objects grow in size, the constructor may grow to contain many attributes. 
 For example, in our most recent immutable  Animal  class example, we had three input parameters:  species ,  age , and  favoriteFoods . If we want to add fi ve new attributes to the object, we’d have to add fi ve new values in the constructor. Every time we add a parameter, the constructor grows! Users who reference our object would also be required to update their constructor calls each time that the object was modifi ed, resulting in a class that would be diffi cult to use and maintain. Alternatively, we could add a new constructor each time we add a parameter,
 but having too many constructors can be quite difficult to manage in practice.  
*/

package DesignPatterns;

import java.util.*;

public class Builder {

	private String species;
	private int age;
	private List<String> favoriteFoods;

	public Builder setAge(int age) {
		this.age = age;
		return this;
	}

	public Builder setSpecies(String species) {
		this.species = species;
		return this;
	}

	public Builder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}

	public Immutable build() {
		return new Immutable(species, age, favoriteFoods);
	}

	public static void main(String[] args) {
		Builder b = new Builder();
		List<String> ls = new ArrayList<>();
		ls.add("Birds");
		Immutable obj = b.setSpecies("Crocodiles").setAge(20).setFavoriteFoods(ls).build();
		System.out.println(obj.getAge());
	}

}
