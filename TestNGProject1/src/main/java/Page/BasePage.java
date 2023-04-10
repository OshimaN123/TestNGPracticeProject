package Page;

import java.util.Random;

public class BasePage {
	public int generateRandomNum(int boundNum) {
		Random rnd=new Random();
		int generateNum=rnd.nextInt(boundNum);
		return generateNum;
	}

}
