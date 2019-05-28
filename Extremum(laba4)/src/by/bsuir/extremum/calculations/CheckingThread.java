package by.bsuir.extremum.calculations;

import java.util.Iterator;
import java.util.Map;

import static by.bsuir.extremum.calculations.ExtremumSearch.currentValue;
import static by.bsuir.extremum.calculations.ExtremumSearch.leftValue;
import static by.bsuir.extremum.calculations.ExtremumSearch.rightValue;

public class CheckingThread extends Thread {

    @Override
    public void run() {
        try {
            ExtremumSearch points = new ExtremumSearch();
            Integer rightPoint, curPoint, leftPoint = 0;

            if (ExtremumSearch.currentValue == null) {

                leftPoint = (Integer) leftValue.getValue();
            }

            currentValue = (Map.Entry) ExtremumSearch.currentValue.next();
            curPoint = (Integer) currentValue.getValue();

            Iterator<Map.Entry<Integer, Integer>> tempIter;
            tempIter = ExtremumSearch.currentValue;
            tempIter.next();
            rightValue = (Map.Entry) tempIter;
            rightPoint = (Integer) rightValue.getValue();

            if (currentValue.getKey().equals(discreteFunction.firstEntry().getKey())) {
                if (curPoint > rightPoint) {
                    points.addToLocalMaximums(curPoint);
                } else {
                    points.addToLocalMinimums(curPoint);
                }
                checkingThreads.countDown();
                throw new InterruptedException();
            }

            if (curPoint > rightPoint && curPoint > leftPoint) {
                points.addToLocalMaximums(curPoint);
                checkingThreads.countDown();
                throw new InterruptedException();
            }

            if (curPoint < rightPoint && curPoint < leftPoint) {
                points.addToLocalMaximums(curPoint);
                checkingThreads.countDown();
                throw new InterruptedException();
            }

            if (currentValue.getKey().equals(discreteFunction.lastEntry().getKey())) {
                if (curPoint > leftPoint) {
                    points.addToLocalMaximums(curPoint);
                } else {
                    points.addToLocalMinimums(curPoint);
                }
                checkingThreads.countDown();
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
