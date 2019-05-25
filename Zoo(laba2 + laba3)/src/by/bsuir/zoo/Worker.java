package by.bsuir.zoo;

import by.bsuir.zoo.animals.Animal;

public class Worker {
	
	public Worker () {}
	
	public void feed(Animal animal) {
		animal.eat();
	}
	
	public void cleanCage(Animal animal) {
		animal.setIsCageClean();
	}
}
