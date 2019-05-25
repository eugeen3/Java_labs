package by.bsuir.zoo.animals;

import by.bsuir.zoo.GUI.AlarmWindow;
import by.bsuir.zoo.GUI.ConstantData;

public class Ostrich extends Bird{
	
	public Ostrich (int b, int w, String n) {
		super(b, w, n);
	}
	
	public void eat() {
		AlarmWindow window = new AlarmWindow();
		window.animalEating(ConstantData.ANIMALS.OSTRICH);
	}
}
