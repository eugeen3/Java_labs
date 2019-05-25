package by.bsuir.zoo.animals;

import by.bsuir.zoo.GUI.AlarmWindow;
import by.bsuir.zoo.GUI.ConstantData;

public class Tiger extends Mammal {
	private int amountOfStripes;
	
	public Tiger(int b, int p, int a, String n) {
		super(b, p, n);
		this.amountOfStripes = a;
	}

	public int getAmountOfStripes() {
		return amountOfStripes;
	}

	public void setAmountOfStripes(int amountOfStripes) {
		this.amountOfStripes = amountOfStripes;
	}
	
	public void eat() {
		AlarmWindow window = new AlarmWindow();
		window.animalEating(ConstantData.ANIMALS.TIGER);
	}
}
