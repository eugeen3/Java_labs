package by.bsuir.extremum.calculations;

import java.util.HashMap;
import java.util.List;

public class ExtremumSearch {
	private HashMap<Integer, Integer> discreteFunction;
	protected int[][] functionPoints;
	protected static List<Integer> localMaximums;
	protected static List<Integer> localMinimums;
	protected static int currentPoint = 0;
	protected int amountOfPoints;
	
	public void parseMap(HashMap<Integer, Integer> func) {	
		functionPoints = new int[2][func.size()];
		
		for (int column = 0; column < func.size(); column++) {
			functionPoints[0][column] = func.get(column);
			functionPoints[0][column] = func.get(column);
		}
	}
	
	public void findExtremums() {
		int extremums[][];
		parseMap(discreteFunction);
		
		for (int i = 0; i < functionPoints.length; i++) {
			CheckingThread checkIfExtremum = new CheckingThread();
			currentPoint++;
			checkIfExtremum.run();
		}
	}

	public void addToMap(String xstr, String ystr) {
		Integer x = Integer.parseInt(xstr);
		Integer y = Integer.parseInt(ystr);
		if (discreteFunction == null) {
			discreteFunction = new HashMap<Integer, Integer>();
		}
		Integer oldValue = new Integer(discreteFunction.put(x, y));
		if (oldValue != null) {
			discreteFunction.put(x, oldValue);
		}
	}
	
	public void addToLocalMaximums(int value) {
		synchronized(this) {
			localMaximums.add(value);
		}
	}

	public void addToLocalMinimums(int value) {
		synchronized(this) {
			localMinimums.add(value);
		}	
	}
	
	public List<Integer> getLocalMaximums() {
		return localMaximums;
	}
	
	public List<Integer> getLocalMinimums() {
		return localMinimums;
	}
	
	/*
	public int[][] getFunctionPoints() {
		if (functionPoints == null) {
			this.parseMap(discreteFunction);
		}
		return functionPoints;
	}
	*/
}
