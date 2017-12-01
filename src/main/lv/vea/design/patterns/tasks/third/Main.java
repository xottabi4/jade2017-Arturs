package lv.vea.design.patterns.tasks.third;

public class Main {


	public static void main(String[] args) {
		ApplicationTimer applicationTimer = ApplicationTimer.getInstance();
		long total = 0;
		for (int i = 0; i < 1000000000; i++) {
			total += i;
		}
		long miliSecondsPassed = applicationTimer.calculateTimePassed();
		double secondsPassed = (double) miliSecondsPassed / 1000.0;
		System.out.println(secondsPassed);
	}
}
