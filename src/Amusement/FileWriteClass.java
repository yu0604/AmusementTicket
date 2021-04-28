package Amusement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriteClass {
	private FileWriter fw;
	boolean isFileExist;

	public FileWriteClass() {
		try {
			File file = new File("ticket_data.csv");
			if (file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter("ticket_data.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileClose() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void headerWrite() throws IOException { // 파일의 헤더를 쓰기 위한 메소드
		if (isFileExist == false) {
			String head = "날짜," + "권종," + "연령구분," + "수량," + "가격," + "우대사항" + "\n";
			fw.write(head);
		}
	}

	public void dataWrite(ArrayList<AmusementType> at_arrlist) throws IOException { // 파일의 데이터를 쓰기 위한 메소드
		for (int i = 0; i < at_arrlist.size(); i++) {
			String result = at_arrlist.get(i).getDate + "," + at_arrlist.get(i).ticket_type + "," + at_arrlist.get(i).age_checker + ","
					+ at_arrlist.get(i).ticket_amount + "," + at_arrlist.get(i).ticket_price + "," + at_arrlist.get(i).priority + "\n";
			fw.write(result);
		}
	}

}
