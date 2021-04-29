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

		// ����ó���� �����Ͽ� 1 �Ǵ� 2�� �Է°����� �޵��� ��
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
		// �ֹε�Ϲ�ȣ�� �Է¹޴� �޼ҵ�
		System.out.println("�ֹι�ȣ�� �Է��ϼ���.");
		String regist_number = scanner.next();
		int[] endday = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// �� ���� ���������� ���� �迭 -> ���� 950332�� ���� ������ ��� ����

		while (true) {
			if (regist_number.length() != 13) {
				// �ֹε�Ϲ�ȣ�� 13�ڸ��� �ƴ� ��� �ùٸ��� �����Ƿ� ����ó��
				System.out.println("�ֹι�ȣ�� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				regist_number = scanner.next();
			} else {
				int month = Integer.parseInt(regist_number.substring(2, 4));
				if (regist_number.charAt(6) != '1' && regist_number.charAt(6) != '2' && regist_number.charAt(6) != '3'
						&& regist_number.charAt(6) != '4') {
					// �ֹε�Ϲ�ȣ ���ڸ� ù��° �ڸ��� 1,2,3,4�� �ƴ� ��� ����ó��
					System.out.println("�ֹι�ȣ�� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					regist_number = scanner.next();
				}
				if (month > 12 || month < 1) {
					// �ֹε�Ϲ�ȣ ���� 1~12�� �ƴ� ��� ����ó��
					System.out.println("�ֹι�ȣ�� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					regist_number = scanner.next();
				} else if (Integer.parseInt(regist_number.substring(4, 6)) < 1
						|| Integer.parseInt(regist_number.substring(4, 6)) > endday[month - 1]) {
					// �ֹε�Ϲ�ȣ ���� 1���� �۰ų� (00�� ��� ����ó��) �� ���� ������ �Ϻ��� ū ���
					System.out.println("�ֹι�ȣ�� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					regist_number = scanner.next();
				}
				break;
			}
		}
		return regist_number;
	}

	public int ticket_amount_input() {
		// Ƽ���� ������ ������ �Է¹޴� �޼ҵ�
		System.out.println("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		int ticket_amount = scanner.nextInt();

		while (true) { // ������ 1���� �۰ų� 10���� ū ��� ����ó��
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
		System.out.println("1. ���� (���� ���� �ڵ�ó��)");
		System.out.println("2. �����");
		System.out.println("3. ����������");
		System.out.println("4. ���ڳ�");
		System.out.println("5. �ӻ��");
		int priority_selection = scanner.nextInt();

		while (true) { // �����׿� ���� ����ó��
			if (priority_selection < 1 || priority_selection > 5) {
				System.out.println("������ ������ �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				priority_selection = scanner.nextInt();
			} else {
				break;
			}
		}
		return priority_selection;
	}

	public int loop_exit() { // ���� while���� Ż���ϱ� ���� input
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("1. Ƽ�� �߱�");
		System.out.println("2. ����");
		int exit = scanner.nextInt();

		while (true) { // 1�� 2�� �ƴ� �ٸ� �ɼ��� ������ ��� ����ó��
			if (exit == 1 || exit == 2) {
				break;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
				exit = scanner.nextInt();
			}
		}
		return exit;
	}

	public int loop_exit2() { // �ٱ� while���� Ż���ϱ� ���� input
		System.out.println("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		int exit = scanner.nextInt();

		while (true) { // 1�� 2�� �ƴ� �ٸ� �ɼ��� ������ ��� ����ó��
			if (exit == 1 || exit == 2) {
				break;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
				exit = scanner.nextInt();
			}
		}
		return exit;
	}

}
