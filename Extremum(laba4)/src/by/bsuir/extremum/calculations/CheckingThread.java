package by.bsuir.extremum.calculations;

import static by.bsuir.extremum.calculations.ExtremumSearch.*;

public class CheckingThread implements Runnable {

    @Override
    public void run() {
        try {
            ExtremumSearch points = new ExtremumSearch();

            if (currentPoint == 0) {
                if (functionPoints[1][currentPoint] > functionPoints[1][currentPoint + 1]) {
                    points.addToLocalMaximums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);
                } else {
                    points.addToLocalMinimums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);
                }
                throw new InterruptedException();
            }

            if (currentPoint == amountOfPoints - 1) {
                if (functionPoints[1][currentPoint] > functionPoints[1][currentPoint - 1]) {
                    points.addToLocalMaximums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);
                } else {
                    points.addToLocalMinimums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);
                }
                throw new InterruptedException();
            }

            if (functionPoints[1][currentPoint] > functionPoints[1][currentPoint - 1] &&
                    functionPoints[1][currentPoint] > functionPoints[1][currentPoint + 1]) {
                points.addToLocalMaximums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);
                throw new InterruptedException();
            }

            if (functionPoints[1][currentPoint] < functionPoints[1][currentPoint - 1] &&
                    functionPoints[1][currentPoint] < functionPoints[1][currentPoint + 1]) {
                points.addToLocalMinimums(functionPoints[0][currentPoint], functionPoints[1][currentPoint]);

                throw new InterruptedException();
            }
            throw new InterruptedException();
        } catch (InterruptedException e) {
            return;
        }
    }
}
