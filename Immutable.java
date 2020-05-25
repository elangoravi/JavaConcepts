package DesignPatterns;

/*
	Design Pattern: Immutable
	 Description: The immutable object pattern is a design pattern based on the idea of creating objects
	 whose state does not change after they are created and can be easily shared across multiple classes. 
	 Immutable objects go hand and hand with encapsulation, except that no setter methods exist that modify the object. 
	 Since the state of an immutable object never changes, they are inherently thread‐safe.  
	 
	Rules:
	   1.  Use a constructor to set all properties of the object.  
	   2.  Mark all of the instance variables private and final . 
	   3.  Don’t define any setter methods.   
	   4.  Don’t allow referenced mutable objects to be modified or accessed directly.  
	   5.  Prevent methods from being overridden.     
*/

import java.util.*;

public final class Immutable {

	private final String species;
	private final int age;
	private final List<String> favoriteFoods;

	public Immutable(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
		/*
		 * With this below change, the caller that creates the object is using the same
		 * reference as the immutable object, which means that it has the ability to
		 * change the List! It is important when creating immutable objects that any
		 * mutable input arguments are copied to the instance instead of being used
		 * directly. Should not be used!
		 * 
		 * this.favoriteFoods = favoriteFoods
		 */
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}

	/*
	 * The problem with the below getter is that the user has direct access to the
	 * List defined in our instance of Immutable. Even though they can’t change the
	 * List object to which it points, they can modify the items in the List, for
	 * example, deleting all of the items by calling getFavoriteFoods().clear().
	 * They could also replace, remove, or even sort the List.
	 * 
	 * public List<String> getFavoriteFoodList() { return favoriteFoods; }
	 */

	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("Birds");
		Immutable obj = new Immutable("Crocodiles", 20, ls);
		System.out.println(obj.getFavoriteFood(0));
	}

}
