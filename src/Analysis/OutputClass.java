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
		System.out.println("==================== 권종 별 판매현황 ====================");
		System.out.printf("주간권 총 %d매\n", ticketTypeArr[5][0]);
		System.out.printf("유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n", ticketTypeArr[0][ConstValueClass.AM_BABY - 1],
				ticketTypeArr[ConstValueClass.AM_CHILD - 1][0], ticketTypeArr[ConstValueClass.AM_TEEN - 1][0],
				ticketTypeArr[ConstValueClass.AM_ADULT - 1][0], ticketTypeArr[ConstValueClass.AM_OLD - 1][0]);
		System.out.printf("주간권 매출 : %d원\n\n", ticketTypeArr[6][0]);

		System.out.printf("야간권 총 %d매\n", ticketTypeArr[5][1]);
		System.out.printf("유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n", ticketTypeArr[ConstValueClass.AM_BABY - 1][1],
				ticketTypeArr[ConstValueClass.AM_CHILD - 1][1], ticketTypeArr[ConstValueClass.AM_TEEN - 1][1],
				ticketTypeArr[ConstValueClass.AM_ADULT - 1][1], ticketTypeArr[ConstValueClass.AM_OLD - 1][1]);
		System.out.printf("야간권 매출 : %d원\n\n", ticketTypeArr[6][1]);

	}

	public void dailysalePrint(int[][] dailysaleArr) {
		System.out.println("=========== 일자별 매출 현황 ===========");
		for (int i = 0; i < dailysaleArr.length; i++) {
			System.out.printf("%4d년 %02d월 %02d일 : 총 매출 %10d원\n", dailysaleArr[i][0] / 10000,
					dailysaleArr[i][0] / 100 % 100, dailysaleArr[i][0] % 100, dailysaleArr[i][1]);
		}
		System.out.println("------------------------------------\n");
	}

	public void priorityPrint(int[] priorityArr) {
		System.out.println("===== 우대권 판매 현황 =====");
		System.out.printf("총 판매 티켓수  : %d매\n", priorityArr[0]);
		System.out.printf("우대 없음      : %d매\n", priorityArr[1]);
		System.out.printf("장애인         : %d매\n", priorityArr[2]);
		System.out.printf("국가유공자      : %d매\n", priorityArr[3]);
		System.out.printf("다자녀         : %d매\n", priorityArr[4]);
		System.out.printf("임산부         : %d매\n", priorityArr[5]);
	}

}
