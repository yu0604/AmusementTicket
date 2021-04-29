package Analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderAnalysis {

	public ArrayList<String[]> FileReadForAnalysis() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test_file.csv"));

		String line;
		
		ArrayList<String[]> arr_str = new ArrayList<String[]>();
		
		while ((line = br.readLine()) != null) {
			arr_str.add(line.split(","));
		}
		
		return arr_str;
	}
}
