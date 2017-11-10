package lv.vea.math.modeling.tasks.first;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getFibonacciSeries(10)));
	}

	private static int[] getFibonacciSeries(int count) {
		int[] fibonacciSeries= new int[count];

		fibonacciSeries[0]=1;
		fibonacciSeries[1]=1;
		for (int i = 2; i < fibonacciSeries.length; i++) {
			fibonacciSeries[i]=fibonacciSeries[i-1]+fibonacciSeries[i-2];
		}
		return fibonacciSeries;
	}


}
