package Amusement;

import java.util.ArrayList;

public class OutputClass {
	public void print_total_ticket(ArrayList<AmusementType> at_arrlist) {
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("================��������================");
		int total_price = 0;
		for (int i = 0; i < at_arrlist.size(); i++) {
			System.out.printf("%s %s x %4d%8d��", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price);
			System.out.println();
			total_price += at_arrlist.get(i).ticket_price;
		}
		
		System.out.printf("����� �Ѿ��� %d�� �Դϴ�.", total_price);
	}
}
