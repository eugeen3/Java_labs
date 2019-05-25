package by.bsuir.zoo;

import java.util.LinkedList;
import java.util.List;

import by.bsuir.zoo.animals.Elephant;
import by.bsuir.zoo.animals.Flamingo;
import by.bsuir.zoo.animals.Ostrich;
import by.bsuir.zoo.animals.Tiger;


public class Zoo {
	private List<Elephant> elephantssInZoo;
	private List<Tiger> tigersInZoo;
	private List<Ostrich> ostrichsInZoo;
	private List<Flamingo> flamingosInZoo;
	private Worker worker;

	public void addElephantToArray(Elephant animal) {
		getElephantssInZoo().add(animal);
	}

	public void addTigerToArray(Tiger animal) {
		getTigersInZoo().add(animal);
	}
	
	public void addOstrichToArray(Ostrich animal) {
		getOstrichsInZoo().add(animal);
	}
	
	public void addFlamingoToArray(Flamingo animal) {
		getFlamingosInZoo().add(animal);
	}
	
	public List<Elephant> getElephantssInZoo() {
		if (elephantssInZoo == null) {
			return new LinkedList<>();
		}
		return elephantssInZoo;
	}

	public List<Tiger> getTigersInZoo() {
		if (ostrichsInZoo == null) {
			return new LinkedList<>();
		}
		return tigersInZoo;
	}
	
	public List<Ostrich> getOstrichsInZoo() {
		if (ostrichsInZoo == null) {
			return new LinkedList<>();
		}
		return ostrichsInZoo;
	}
	
	public List<Flamingo> getFlamingosInZoo() {
		if (ostrichsInZoo == null) {
			return new LinkedList<>();
		}
		return flamingosInZoo;
	}
}
