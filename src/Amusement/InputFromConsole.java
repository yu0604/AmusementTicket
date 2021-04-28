package Amusement;

import java.util.Scanner;

public class InputFromConsole {
	Scanner scanner = null;

	protected void finalize() {
		scanner.close();
	}

	InputFromConsole() {
		scanner = new Scanner(System.in);
	}

	public int ticket_type_selection_input() {
		// �ְ��� �Ǵ� �߰����� ������ �Է¹޴� �޼ҵ� (1 �Ǵ� 2�� ������)
		System.out.println("������ �����ϼ���.");
		System.out.println("1. �ְ���");
		System.out.println("2. �߰���");
		int ticket_type_selection = scanner.nextInt();

		while (true) {
			if (ticket_type_selection == ConstValueClass.AM_DAY_TYPE
					|| ticket_type_selection == ConstValueClass.AM_NIGHT_TYPE) {
				break;
			} else {
				System.out.println("�ְ��� �Ǵ� �߰����� �������ּ���");
				System.out.println("(Please press option 1 or 2)");
				ticket_type_selection = scanner.nextInt();
			}
		}
		return ticket_type_selection;
	}

	public String regist_number_input() {
		// �ֹε�Ϲ�ȣ�� ������ �Է¹޴� �޼ҵ�
		System.out.println("�ֹι�ȣ�� �Է��ϼ���.");
		String regist_number = scanner.nextLine();

		while (true) {
			if (regist_number.length() != 13) {
				System.out.println("�ֹι�ȣ�� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				regist_number = scanner.nextLine();
			} else {
				break;
			}
		}
		return regist_number;
	}

	public int ticket_amount_input() {
		// Ƽ���� ������ ������ �Է¹޴� �޼ҵ�
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		int ticket_amount = scanner.nextInt();

		while (true) {
			if (ticket_amount < 1 || ticket_amount > 10) {
				System.out.println("Ƽ�� ������ �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				ticket_amount = scanner.nextInt();
			} else {
				break;
			}
		}
		return ticket_amount;
	}

	public int priority_selection_input() {
		// ������ ������ �Է¹޴� �޼ҵ�
		System.out.println("�������� �����ϼ���.");
		int priority_selection = scanner.nextInt();
		
		while (true) {
			if (priority_selection < 1 || priority_selection > 5) {
				System.out.println("������ ������ �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				priority_selection = scanner.nextInt();
			} else {
				break;
			}
		}
		
		return priority_selection;
	}
}
