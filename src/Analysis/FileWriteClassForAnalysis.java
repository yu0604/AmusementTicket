package Analysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriteClassForAnalysis {
	private FileWriter fw;
	boolean isFileExist;

	public void fileOpenTicketType() {
		try {
			File file = new File("ticket_type_analysis.csv");
			if (file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter("ticket_type_analysis.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileOpenDaily() {
		try {
			File file = new File("ticket_daily_analysis.csv");
			if (file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter("ticket_daily_analysis.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileOpenPriority() {
		try {
			File file = new File("ticket_daily_priority.csv");
			if (file.exists() == false) {
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter("ticket_daily_priority.csv", true);
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

	public void headerWriteTicketType() throws IOException {
		if (isFileExist == false) {
			String head = String.format("%s,%s,%s\n", "����", "�ְ���", "�߰���");
			fw.write(head);
		}
	}

	public void headerWriteDaily() throws IOException {
		if (isFileExist == false) {
			String head = String.format("%s,%s\n", "����", "�� ����");
			fw.write(head);
		}
	}

	public void headerWritePriority() throws IOException {
		if (isFileExist == false) {
			String head = String.format("%s,%s\n", "����", "�Ǹ� �ż�");
			fw.write(head);
		}
	}

	public void dataWriteTicketType(int[][] ticketTypeArr) throws IOException {
		String[] array = { "����", "���", "û�ҳ�", "�", "����", "�հ�", "����" };
		for (int i = 0; i < ticketTypeArr.length; i++) {
			String result = array[i] + ",";
			for (int j = 0; j < ticketTypeArr[i].length; j++) {
				if (j == ticketTypeArr[i].length - 1) {
					result = result + String.format("%s\n", Integer.toString(ticketTypeArr[i][j]));
				} else {
					result = result + String.format("%s,", Integer.toString(ticketTypeArr[i][j]));
				}
			}
			fw.write(result);
		}
	}

	public void dataWriteDaily(int[][] dailysaleArr) throws IOException {
		for (int i = 0; i < dailysaleArr.length; i++) {
			String result = "";
			for (int j = 0; j < dailysaleArr[i].length; j++) {
				if (j == dailysaleArr[i].length - 1) {
					result = result + String.format("%s\n", Integer.toString(dailysaleArr[i][j]));
				} else {
					result = result + String.format("%s,", Integer.toString(dailysaleArr[i][j]));
				}
			}
			fw.write(result);
		}
	}

	public void dataWritePriority(int[] priorityArr) throws IOException {
		String[] array = { "�� �Ǹ� Ƽ�� ��", "��� ����", "�����", "����������", "���ڳ�", "�ӻ��" };
		for (int i = 0; i < priorityArr.length; i++) {
			String result = array[i] + ",";
			result = result + String.format("%s\n", Integer.toString(priorityArr[i]));
			fw.write(result);
		}
	}
}
