package by.bsuir.extremum.calculations;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ExtremumSearch {
    protected static TreeMap<Integer, Integer> discreteFunction;
    protected static List<Integer> localMaximums;
    protected static List<Integer> localMinimums;
    protected static Iterator<Map.Entry<Integer, Integer>> currentValue, leftValue, rightValue;
    protected static CountDownLatch checkingThreads;

    public void findExtremes() {
        if(discreteFunction == null) {
            //MSG
        }

        checkingThreads = new CountDownLatch(discreteFunction.size());
        CheckingThread first = new CheckingThread();
        first.run();
        while (currentValue.hasNext()){
            CheckingThread checkIfExtremum = new CheckingThread();
            checkIfExtremum.run();
        }
        try {
            checkingThreads.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Local maxis" + localMaximums);
        System.out.println("Local minis" + localMinimums);
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