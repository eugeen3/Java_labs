package by.bsuir.extremum.calculations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExtremumSearch {
    private HashMap<Integer, Integer> discreteFunction;
    protected int[][] functionPoints;
    protected static List<Integer> localMaximums;
    protected static List<Integer> localMinimums;
    protected static Iterator<HashMap> currentPoint = null;
    protected int amountOfPoints;

    public void findExtremes() {
        for (int i = 0; i < functionPoints.length; i++) {
            CheckingThread checkIfExtremum = new CheckingThread();
            //currentPoint++;
            checkIfExtremum.run();
        }
    }

    public void addToMap(String xStr, String yStr) {
        Integer x = Integer.parseInt(xStr);
        Integer y = Integer.parseInt(yStr);

        if(discreteFunction == null) {
            discreteFunction = new HashMap<Integer, Integer>();
        }
        discreteFunction.put(x, y);
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
}