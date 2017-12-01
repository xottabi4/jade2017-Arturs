package lv.vea.design.patterns.tasks.third;

public class ApplicationTimer {

	private static long startTime;

	private static ApplicationTimer singleton ;

	static {
		singleton = new ApplicationTimer();
		startTime = System.currentTimeMillis();
	}
	
	private ApplicationTimer() {
		// nothing to do here
	}

	public static ApplicationTimer getInstance() {
		return singleton;
	}

	public long calculateTimePassed() {
		return System.currentTimeMillis() - startTime;
	}

}
