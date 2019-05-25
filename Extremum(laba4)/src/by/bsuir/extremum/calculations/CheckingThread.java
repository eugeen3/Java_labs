package by.bsuir.extremum.calculations;

public class CheckingThread extends Thread {

    @Override
    public void run() {
        ExtremumSearch points = new ExtremumSearch();
        int leftValue, currentValue, rightValue;
        currentValue = points.functionPoints[1][ExtremumSearch.currentPoint];

        if (ExtremumSearch.currentPoint == 0) {
            leftValue = currentValue - 1;
        }
        else {
            leftValue =  points.functionPoints[1][ExtremumSearch.currentPoint - 1];
        }

        if (ExtremumSearch.currentPoint == points.amountOfPoints) {
            rightValue =  currentValue - 1;
        }
        else {
            rightValue =  points.functionPoints[1][ExtremumSearch.currentPoint + 1];
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