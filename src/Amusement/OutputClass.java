package Amusement;

import java.util.ArrayList;

public class OutputClass {
	public void print_total_ticket(ArrayList<AmusementType> at_arrlist) {
		// AmusementType 형의 ArrayList를 입력값으로 받아서 데이터를 출력하는 메소드
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("=====================에버랜드=====================");
		int total_price = 0; // 티켓의 총합을 나타내는 변수
		for (int i = 0; i < at_arrlist.size(); i++) {
			// 우대적용이 없는 경우 "우대적용 없음" 출력 / 우대적용이 있는 경우 OOO 우대적용 형태로 출력하기 위해 조건문 사용
			if (at_arrlist.get(i).priority.contains("없음")) {
				System.out.printf("%5s %5s x %d%10d원  *우대적용 %s", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price, at_arrlist.get(i).priority);
			} else {
				System.out.printf("%5s %5s x %d%10d원  *%s 우대적용", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price, at_arrlist.get(i).priority);
			}
			System.out.println();
			total_price += at_arrlist.get(i).ticket_price; // 티켓의 가격을 더해줌
		}
		
		System.out.printf("\n입장료 총액은 %d원 입니다.\n", total_price);
	}
}
