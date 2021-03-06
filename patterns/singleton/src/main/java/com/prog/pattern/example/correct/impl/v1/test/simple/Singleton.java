package com.prog.pattern.example.correct.impl.v1.test.simple;

// NOTE: This is not thread safe!

public class Singleton {
	private static Singleton uniqueInstance;
 
	private Singleton() {}

	//Laz Loading creation
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public String getDescription() {
		return "I'm a lazy loaded Singleton!";
	}
}
