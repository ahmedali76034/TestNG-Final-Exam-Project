package page;

import java.util.Random;

public class BasePage {

	public static int getRandomNumber(int maxInt) {

		Random random = new Random();
		int randomNumber = random.nextInt(maxInt);

		return randomNumber;

	}

}
