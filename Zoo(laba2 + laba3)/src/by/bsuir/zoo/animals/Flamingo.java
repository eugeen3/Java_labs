package by.bsuir.zoo.animals;

import by.bsuir.zoo.GUI.AlarmWindow;
import by.bsuir.zoo.GUI.ConstantData;

public class Flamingo extends Bird{

	public Flamingo (int b, int w, String n) {
		super(b, w, n);
	}
	
	public void fly() {
		AlarmWindow window = new AlarmWindow();
		window.flamingoFlying();
	}
	
	public void eat() {
		AlarmWindow window = new AlarmWindow();
		window.animalEating(ConstantData.ANIMALS.FLAMINGO);
	}
}
