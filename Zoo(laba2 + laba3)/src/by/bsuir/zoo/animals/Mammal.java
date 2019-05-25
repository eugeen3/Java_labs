package by.bsuir.zoo.animals;

public abstract class Mammal extends Animal{
	protected int pawsAmount;

	public Mammal(int b, int p, String n) {
		super(b, n);
		this.pawsAmount = p;
	}

	public int getPawsAmount() {
		return pawsAmount;
	}
}
