package by.bsuir.zoo.animals;

public abstract class Bird extends Animal{
	protected int wingsLength;

	public Bird(int b, int w, String n) {
		super(b, n);
		this.wingsLength = w;
	}
	
	public int getWingLength() {
		return wingsLength;
	}
}
