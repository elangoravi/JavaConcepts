package DesignPatterns;

/*
Design Pattern: Singleton 
Description : One instance of an object is created and used across the application

Private instance variables and public getters/setters ensures encapsulation of data
getters: getName(Wrapper Boolean)/isName(primitive boolean) -- get<CamelCaseOfInstanceVariables>
setters: setName
*/

public class Singleton {

	private static Singleton instance; // Instance should be private static final or effectively final
	private String name;
	private int id;

	private Singleton() { // Private constructor ensured the class is effectively final even if the
							// instance variable is not marked final
	}

	/*
	 * static { instance = new Singleton(); } // Static Initializer blocks can be
	 * used to create an instance at static class level
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static synchronized Singleton getInstance() { // static synchronized(thread-safe) method to get instance for
															// the class
		if (instance == null) { // Lazy Instantiation technique, created when called for the first time
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
		obj.setName("Singleton Pattern");
		System.out.println(obj.getName());
	}
}
