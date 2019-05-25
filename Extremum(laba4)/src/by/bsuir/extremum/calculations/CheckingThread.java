package by.bsuir.extremum.calculations;

public class CheckingThread extends Thread {
	
	@Override
	public void run() {
		ExtremumSearch points = new ExtremumSearch();
		int localExtremum = 0;
		int leftValue, currentValue, rightValue;
		currentValue = points.functionPoints[1][points.currentPoint];
		
		if (ExtremumSearch.currentPoint == 0) {
			leftValue = currentValue - 1;
		}
		else {
			leftValue =  points.functionPoints[1][points.currentPoint - 1]; 
		}
		
		if (points.currentPoint == points.amountOfPoints) {
			rightValue =  currentValue - 1;
		}
		else {
			rightValue =  points.functionPoints[1][points.currentPoint + 1];
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
