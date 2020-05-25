/*
 Design: Factory
 Description: The factory pattern, sometimes referred to as the factory method pattern, is a creational pattern
 based on the idea of using a factory class to produce instances of objects based on a set of input parameters

Motivation:
 As you saw with the builder pattern, object creation can be quite complex.
 We’d like some way of encapsulating object creation to deal with the complexity of object creation, 
 including selecting which subclass to use, as well as loosely coupling the underlying creation implementation. 
 
*/
package DesignPatterns;

abstract class Food {
	private int quantity;

	public Food(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public abstract void consumed();
}

class Hay extends Food {
	public Hay(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Hay eaten: " + getQuantity());
	}
}

class Pellets extends Food {
	public Pellets(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Pellets eaten: " + getQuantity());
	}
}

class Fish extends Food {
	public Fish(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Fish eaten: " + getQuantity());
	}
}

public class Factory {

	public static Food getFood(String animalName) {
		switch (animalName) {
		case "zebra":
			return new Hay(100);
		case "rabbit":
			return new Pellets(5);
		case "goat":
			return new Pellets(30);
		case "polar bear":
			return new Fish(10);
		} // Good practice to throw an exception if no matching subclass could be found
		throw new UnsupportedOperationException("Unsupported animal: " + animalName);
	}

	public static void main(String[] args) {
		final Food food = Factory.getFood("polar bear");
		food.consumed();
	}
}
