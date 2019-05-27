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

        currentValue = (Map.Entry)currentPoint.next();
        if (currentValue.getKey().equals(discreteFunction.firstEntry().getKey())) {
            Iterator<Map.Entry<Integer, Integer>> tempIter;
            tempIter = currentPoint;
            tempIter.next();
            rightValue = (Map.Entry)tempIter;
            Integer curVal = (Integer)currentValue.getValue();
            Integer rightVal = (Integer)rightValue.getValue();

            if (curVal > rightVal) {
                points.addToLocalMaximums(curVal);
            }
            else {
                points.addToLocalMinimums(curVal);
            }
        }

        if (currentPoint) {
            leftValue = currentValue - 1;
        }
        else {
            leftValue =  points.functionPoints[1][currentPoint - 1];
        }

        if (currentPoint == points.amountOfPoints) {
            rightValue =  currentValue - 1;
        }
        else {
            rightValue =  points.functionPoints[1][currentPoint + 1];
        }

        if (currentValue > leftValue) {
            if (currentValue > rightValue) {
                points.addToLocalMaximums(currentValue);
            }
        }

        if (currentValue < leftValue) {
            if (currentValue < rightValue) {
                points.addToLocalMinimums(currentValue);
            }
        }
    }
}