package alea;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import alea.filehandler.BulkReader;
import alea.filehandler.BulkWriter;
import alea.filehandler.IFileReader;
import alea.filehandler.IFileWriter;
import alea.util.RandomNumbersGenerator;

public class Assignment {
	
	private final static Logger LOGGER = Logger.getLogger(Assignment.class.getName());

	private static int min = 1;
	private static int max = 1_000_000;
	private static int count = 1_000_000;

	public static void main(String[] args) {		
		Assignment main = new Assignment();
		
		List<Integer> randomNumbers = RandomNumbersGenerator.generateRandomNumbers(min, max, count);
		
		String randomFile = "random_numbers.txt";
		main.writeToFile(randomNumbers, randomFile);
		
		String sortedFile = "sorted_numbers.txt";
		List<Integer> sortedNumbers = main.readFromFile(randomFile).stream().sorted().collect(Collectors.toList());
		main.writeToFile(sortedNumbers, sortedFile);
	}
	
	private List<Integer> readFromFile(String file) {
		String path = getPath(file);
		IFileReader reader = new BulkReader(path);
		List<Integer> numbersFromFile = reader.read();
		LOGGER.info("Read file successful: " + path);
		
		return numbersFromFile;
	}
	
	private void writeToFile(List<Integer> list, String file) {
		String path = getPath(file);
		IFileWriter writer = new BulkWriter(list, path);
		writer.write();
		LOGGER.info("Write file successful: " + path);
	}
	
	private String getPath(String file) {
		return System.getProperty("user.dir") + "\\" + file;
	}
}
