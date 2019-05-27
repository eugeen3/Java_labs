package by.bsuir.extremum.calculations;

import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

public class ExtremumSearch {
    protected static TreeMap<Integer, Integer> discreteFunction;
    protected static List<Integer> localMaximums;
    protected static List<Integer> localMinimums;
    protected static Iterator<Map.Entry<Integer, Integer>> currentPoint;
    protected static Iterator<Map.Entry<Integer, Integer>> leftPoint;
    protected static Iterator<Map.Entry<Integer, Integer>> rightPoint;
    protected int amountOfPoints;

    public void findExtremes() {
        if(discreteFunction == null) {
            //MSG
        }

        while (currentPoint.hasNext()){
            CheckingThread checkIfExtremum = new CheckingThread();
            checkIfExtremum.run();
        }
    }

    public void addToMap(String xStr, String yStr) {
        Integer x = Integer.parseInt(xStr);
        Integer y = Integer.parseInt(yStr);

        if(discreteFunction == null) {
            discreteFunction = new TreeMap<Integer, Integer>();
        }
        discreteFunction.put(x, y);
    }

    public void addToLocalMaximums(Integer value) {
        synchronized(this) {
            localMaximums.add(value);
        }
    }

    public void addToLocalMinimums(Integer value) {
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