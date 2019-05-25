package by.bsuir.zoo.animals;

import by.bsuir.zoo.GUI.AlarmWindow;
import by.bsuir.zoo.GUI.ConstantData;

public class Elephant extends Mammal {
	private int trunkLength;
	
	public Elephant(int b, int p, int t, String n) {
		super(b, p, n);
		this.trunkLength = t;
	}
	
	public int getTrunkLength() {
		return trunkLength;
	}

	public void setTrunkLength(int trunkLength) {
		this.trunkLength = trunkLength;
	}
	
	public void eat() {
		AlarmWindow window = new AlarmWindow();
		window.animalEating(ConstantData.ANIMALS.ELEPHANT);
	}
}
