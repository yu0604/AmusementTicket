package Analysis;

import java.util.ArrayList;

public class OutputClass {
	FileReaderAnalysis fa = new FileReaderAnalysis();

	public void printFile(ArrayList<String[]> arr_str) {
		System.out.println("================ticket_data.csv================");

		for (int i = 0; i < arr_str.size(); i++) {
			for (int j = 0; j < arr_str.get(i).length; j++) {
				System.out.printf("%-7s ", arr_str.get(i)[j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------\n");
	}

	public void ticketTypeDay(int[][] ticketTypeArr) {
		System.out.println("==================== ���� �� �Ǹ���Ȳ ====================");
		System.out.printf("�ְ��� �� %d��\n", ticketTypeArr[5][0]);
		System.out.printf("���� %d��, ��� %d��, û�ҳ� %d��, � %d��, ���� %d��\n", ticketTypeArr[0][ConstValueClass.AM_BABY - 1],
				ticketTypeArr[ConstValueClass.AM_CHILD - 1][0], ticketTypeArr[ConstValueClass.AM_TEEN - 1][0],
				ticketTypeArr[ConstValueClass.AM_ADULT - 1][0], ticketTypeArr[ConstValueClass.AM_OLD - 1][0]);
		System.out.printf("�ְ��� ���� : %d��\n\n", ticketTypeArr[6][0]);

		System.out.printf("�߰��� �� %d��\n", ticketTypeArr[5][1]);
		System.out.printf("���� %d��, ��� %d��, û�ҳ� %d��, � %d��, ���� %d��\n", ticketTypeArr[ConstValueClass.AM_BABY - 1][1],
				ticketTypeArr[ConstValueClass.AM_CHILD - 1][1], ticketTypeArr[ConstValueClass.AM_TEEN - 1][1],
				ticketTypeArr[ConstValueClass.AM_ADULT - 1][1], ticketTypeArr[ConstValueClass.AM_OLD - 1][1]);
		System.out.printf("�߰��� ���� : %d��\n\n", ticketTypeArr[6][1]);

	}

	public void dailysalePrint(int[][] dailysaleArr) {
		System.out.println("=========== ���ں� ���� ��Ȳ ===========");
		for (int i = 0; i < dailysaleArr.length; i++) {
			System.out.printf("%4d�� %02d�� %02d�� : �� ���� %10d��\n", dailysaleArr[i][0] / 10000,
					dailysaleArr[i][0] / 100 % 100, dailysaleArr[i][0] % 100, dailysaleArr[i][1]);
		}
		System.out.println("------------------------------------\n");
	}

	public void priorityPrint(int[] priorityArr) {
		System.out.println("===== ���� �Ǹ� ��Ȳ =====");
		System.out.printf("�� �Ǹ� Ƽ�ϼ�  : %d��\n", priorityArr[0]);
		System.out.printf("��� ����      : %d��\n", priorityArr[1]);
		System.out.printf("�����         : %d��\n", priorityArr[2]);
		System.out.printf("����������      : %d��\n", priorityArr[3]);
		System.out.printf("���ڳ�         : %d��\n", priorityArr[4]);
		System.out.printf("�ӻ��         : %d��\n", priorityArr[5]);
	}

}
