package alea.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbersGenerator {
	
	public static List<Integer> generateRandomNumbers(int min, int max, int count) {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			randomNumbers.add(ThreadLocalRandom.current().nextInt(min, max + 1));
		}
		
		return randomNumbers;
	}
}
