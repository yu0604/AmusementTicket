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
		// 주간권 또는 야간권을 선택해 입력받는 메소드 (1 또는 2를 리턴함)
		System.out.println("권종을 선택하세요.");
		System.out.println("1. 주간권");
		System.out.println("2. 야간권");
		int ticket_type_selection = scanner.nextInt();

		while (true) {
			if (ticket_type_selection == ConstValueClass.AM_DAY_TYPE
					|| ticket_type_selection == ConstValueClass.AM_NIGHT_TYPE) {
				break;
			} else {
				System.out.println("주간권 또는 야간권을 선택해주세요");
				System.out.println("(Please press option 1 or 2)");
				ticket_type_selection = scanner.nextInt();
			}
		}
		return ticket_type_selection;
	}

	public String regist_number_input() {
		// 주민등록번호를 선택해 입력받는 메소드
		System.out.println("주민번호를 입력하세요.");
		String regist_number = scanner.nextLine();

		while (true) {
			if (regist_number.length() != 13) {
				System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
				regist_number = scanner.nextLine();
			} else {
				break;
			}
		}
		return regist_number;
	}

	public int ticket_amount_input() {
		// 티켓의 수량을 선택해 입력받는 메소드
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		int ticket_amount = scanner.nextInt();

		while (true) {
			if (ticket_amount < 1 || ticket_amount > 10) {
				System.out.println("티켓 수량이 올바르지 않습니다. 다시 입력해주세요.");
				ticket_amount = scanner.nextInt();
			} else {
				break;
			}
		}
		return ticket_amount;
	}

	public int priority_selection_input() {
		// 우대사항 선택해 입력받는 메소드
		System.out.println("우대사항을 선택하세요.");
		int priority_selection = scanner.nextInt();
		
		while (true) {
			if (priority_selection < 1 || priority_selection > 5) {
				System.out.println("우대사항 선택이 올바르지 않습니다. 다시 입력해주세요.");
				priority_selection = scanner.nextInt();
			} else {
				break;
			}
		}
		
		return priority_selection;
	}
}
