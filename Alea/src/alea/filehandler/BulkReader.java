package alea.filehandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BulkReader implements IFileReader {
	
	private String file;
	
	public BulkReader(String file) {
		this.file = file;
	}

	@Override
	public List<Integer> read() {
		List<Integer> list = new ArrayList<>();
		try(Stream<String> stream = Files.lines(Paths.get(file))) {
			list = stream
					.filter(line -> !line.equals("\n"))
					.map(line -> Integer.parseInt(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
