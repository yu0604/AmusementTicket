package Amusement;

import java.util.ArrayList;

public class OutputClass {
	public void print_total_ticket(ArrayList<AmusementType> at_arrlist) {
		// AmusementType ���� ArrayList�� �Է°����� �޾Ƽ� �����͸� ����ϴ� �޼ҵ�
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("=====================��������=====================");
		int total_price = 0; // Ƽ���� ������ ��Ÿ���� ����
		for (int i = 0; i < at_arrlist.size(); i++) {
			// ��������� ���� ��� "������� ����" ��� / ��������� �ִ� ��� OOO ������� ���·� ����ϱ� ���� ���ǹ� ���
			if (at_arrlist.get(i).priority.contains("����")) {
				System.out.printf("%5s %5s x %d%10d��  *������� %s", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price, at_arrlist.get(i).priority);
			} else {
				System.out.printf("%5s %5s x %d%10d��  *%s �������", at_arrlist.get(i).ticket_type, at_arrlist.get(i).age_checker, at_arrlist.get(i).ticket_amount, at_arrlist.get(i).ticket_price, at_arrlist.get(i).priority);
			}
			System.out.println();
			total_price += at_arrlist.get(i).ticket_price; // Ƽ���� ������ ������
		}
		
		System.out.printf("\n����� �Ѿ��� %d�� �Դϴ�.\n", total_price);
	}
}
