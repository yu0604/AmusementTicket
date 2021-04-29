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

		// 예외처리를 진행하여 1 또는 2만 입력값으로 받도록 함
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
		// 주민등록번호를 입력받는 메소드
		System.out.println("주민번호를 입력하세요.");
		String regist_number = scanner.next();
		int[] endday = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 각 월의 마지막일을 넣은 배열 -> 이후 950332와 같은 오류를 잡기 위함

		while (true) {
			if (regist_number.length() != 13) {
				// 주민등록번호가 13자리가 아닌 경우 올바르지 않으므로 예외처리
				System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
				regist_number = scanner.next();
			} else {
				int month = Integer.parseInt(regist_number.substring(2, 4));
				if (regist_number.charAt(6) != '1' && regist_number.charAt(6) != '2' && regist_number.charAt(6) != '3'
						&& regist_number.charAt(6) != '4') {
					// 주민등록번호 뒷자리 첫번째 자리가 1,2,3,4가 아닌 경우 예외처리
					System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
					regist_number = scanner.next();
				}
				if (month > 12 || month < 1) {
					// 주민등록번호 월이 1~12가 아닌 경우 예외처리
					System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
					regist_number = scanner.next();
				} else if (Integer.parseInt(regist_number.substring(4, 6)) < 1
						|| Integer.parseInt(regist_number.substring(4, 6)) > endday[month - 1]) {
					// 주민등록번호 일이 1보다 작거나 (00인 경우 예외처리) 각 월의 마지막 일보다 큰 경우
					System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
					regist_number = scanner.next();
				}
				break;
			}
		}
		return regist_number;
	}

	public int ticket_amount_input() {
		// 티켓의 수량을 선택해 입력받는 메소드
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		int ticket_amount = scanner.nextInt();

		while (true) { // 수량이 1보다 작거나 10보다 큰 경우 예외처리
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
		System.out.println("1. 없음 (나이 우대는 자동처리)");
		System.out.println("2. 장애인");
		System.out.println("3. 국가유공자");
		System.out.println("4. 다자녀");
		System.out.println("5. 임산부");
		int priority_selection = scanner.nextInt();

		while (true) { // 우대사항에 대한 예외처리
			if (priority_selection < 1 || priority_selection > 5) {
				System.out.println("우대사항 선택이 올바르지 않습니다. 다시 입력해주세요.");
				priority_selection = scanner.nextInt();
			} else {
				break;
			}
		}
		return priority_selection;
	}

	public int loop_exit() { // 안쪽 while문을 탈출하기 위한 input
		System.out.println("계속 발권 하시겠습니까?");
		System.out.println("1. 티켓 발권");
		System.out.println("2. 종료");
		int exit = scanner.nextInt();

		while (true) { // 1과 2가 아닌 다른 옵션을 선택한 경우 예외처리
			if (exit == 1 || exit == 2) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
				exit = scanner.nextInt();
			}
		}
		return exit;
	}

	public int loop_exit2() { // 바깥 while문을 탈출하기 위한 input
		System.out.println("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		int exit = scanner.nextInt();

		while (true) { // 1과 2가 아닌 다른 옵션을 선택한 경우 예외처리
			if (exit == 1 || exit == 2) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
				exit = scanner.nextInt();
			}
		}
		return exit;
	}

}
