package utils;

public class WaitAction {

	public static void time(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {}
	}

}
