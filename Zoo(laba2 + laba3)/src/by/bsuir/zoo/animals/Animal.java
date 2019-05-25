package by.bsuir.zoo.animals;

public abstract class Animal {
	protected String name;
	protected int bodyLength;
	protected boolean isCageClean;
	
	public Animal(int b, String n) {
		this.bodyLength = b;
		this.name = n;
	}
	
	public void eat() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public boolean getIsCageClean() {
		return isCageClean;
	}

	public void setIsCageClean() {
		this.isCageClean = true;
	}
}
