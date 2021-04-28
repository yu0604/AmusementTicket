package Amusement;

import java.util.ArrayList;

public class OutputClass {
	public void print_total_ticket(ArrayList<AmusementType> at_arrlist) {
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("================에버랜드================");
		int total_price = 0;
		for (int i = 0; i < at_arrlist.size(); i++) {
			System.out.printf("%s %s x %4d%8d원", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price);
			System.out.println();
			total_price += at_arrlist.get(i).ticket_price;
		}
		
		System.out.printf("입장료 총액은 %d원 입니다.", total_price);
	}
}
