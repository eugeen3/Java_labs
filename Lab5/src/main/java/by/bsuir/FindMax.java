package by.bsuir;

public class FindMax {
	
	public int compare(int[] values) {
		int maxValue = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > maxValue) 
				maxValue = values[i];
		}	
        return maxValue;
    }
}
