package alea.filehandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BulkWriter implements IFileWriter {
	
	private List<Integer> list = new ArrayList<>();
	private String file;
	
	public BulkWriter(List<Integer> list, String file) {
		this.list = list;
		this.file = file;
	}
	
	@Override
	public void write() {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))){
			for (Integer item : list) {
				writer.write(item.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
