package by.bsuir.extremum.calculations;

import by.bsuir.extremum.GUI.ConstantData;
import by.bsuir.extremum.GUI.MainWindow;
import by.bsuir.extremum.GUI.ResultWindow;

import java.net.Inet4Address;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ExtremumSearch {
    private static TreeMap<Integer, Integer> discreteFunction;
    protected static TreeMap<Integer, Integer> localMaximums;
    protected static TreeMap<Integer, Integer> localMinimums;
    protected static int currentPoint;
    protected static int functionPoints[][];
    protected static int amountOfPoints;

    public void findExtremes() {
            localMaximums = new TreeMap<Integer, Integer>();
            localMinimums = new TreeMap<Integer, Integer>();
            currentPoint = 0;
            amountOfPoints = discreteFunction.size();
            functionPoints = new int[2][amountOfPoints];
            Integer x[] = discreteFunction.keySet().toArray(new Integer[amountOfPoints]);
            Integer y[] = discreteFunction.values().toArray(new Integer[amountOfPoints]);

            for (int i = 0; i < amountOfPoints; i++) {
                functionPoints[0][i] = x[i];
                functionPoints[1][i] = y[i];
            }
            discreteFunction.get(1);

            CheckingThread threadsArray[] = new CheckingThread[amountOfPoints];
            while (currentPoint < amountOfPoints) {
                threadsArray[currentPoint] = new CheckingThread();
                threadsArray[currentPoint].run();
                currentPoint++;
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

    public void addToLocalMaximums(Integer pointX, Integer pointY) {
        synchronized(this) {
            localMaximums.put(pointX, pointY);
        }
    }

    public void addToLocalMinimums(Integer pointX, Integer pointY) {
        synchronized(this) {
            localMinimums.put(pointX, pointY);
        }
    }

    public TreeMap<Integer, Integer> getLocalMaximums() {
        return localMaximums;
    }

    public TreeMap<Integer, Integer> getLocalMinimums() {
        return localMinimums;
    }
}