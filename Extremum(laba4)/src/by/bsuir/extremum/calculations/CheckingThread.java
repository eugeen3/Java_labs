package by.bsuir.extremum.calculations;

import java.util.Iterator;
import java.util.Map;
import java.util.Deque;

import static by.bsuir.extremum.calculations.ExtremumSearch.currentPoint;
import static by.bsuir.extremum.calculations.ExtremumSearch.discreteFunction;

public class CheckingThread extends Thread {

    @Override
    public void run() {
        ExtremumSearch points = new ExtremumSearch();
        Map.Entry currentValue,leftValue, rightValue;

        if (currentPoint == null) {
            leftValue = (Map.Entry)currentPoint;
            Integer leftPoint = (Integer)leftValue.getValue();
        }
        
        currentValue = (Map.Entry)currentPoint.next();
        Integer curPoint = (Integer)currentValue.getValue();
        
        Iterator<Map.Entry<Integer, Integer>> tempIter;
        tempIter = currentPoint;
        tempIter.next();
        rightValue = (Map.Entry)tempIter;
        Integer rightPoint = (Integer)rightValue.getValue();
        
        if (currentValue.getKey().equals(discreteFunction.firstEntry().getKey())) {
            if (curPoint > rightPoint) {
                points.addToLocalMaximums(curPoint);
            }
            else {
                points.addToLocalMinimums(curPoint);
            }
            exit(0);
        }

        if (curPoint > rightPoint && curPoint > leftPoint) {
            points.addToLocalMaximums(curPoint);
            exit(0);
        }
        
        if (curPoint < rightPoint && curPoint < leftPoint) {
            points.addToLocalMaximums(curPoint);
            exit(0);
        }

        if (currentValue.getKey().equals(discreteFunction.lastEntry().getKey())) {
            if (curPoint > leftPoint) {
                points.addToLocalMaximums(curVal);
            }
            else {
                points.addToLocalMinimums(curVal);
            }
            exit(0);
        }
    }
}
