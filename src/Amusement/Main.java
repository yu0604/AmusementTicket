package Amusement;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		InputFromConsole ifc = new InputFromConsole();
		ProcessingClass pc = new ProcessingClass();
		OutputClass opc = new OutputClass();
		FileWriteClass fwc = new FileWriteClass();

		ArrayList<AmusementType> at_arrlist;
		AmusementType at;

		int exit = 0; // while문을 빠져나가기 위한 임시 변수

		fwc.headerWrite(); // 파일의 헤더를 작성함

		while (true) {
			at_arrlist = new ArrayList<AmusementType>();

			while (true) {
				at = new AmusementType(); // AmusementType 객체 생성
				at.getDate = pc.getDate(); // 오늘 날짜
				at.ticket_type = pc.ticket_type(ifc.ticket_type_selection_input()); // 주간권, 야간권
				at.age_checker = pc.age_checker(ifc.regist_number_input()); // 유아, 소인, 청소년, 대인, 노인
				at.ticket_amount = pc.ticket_amount(ifc.ticket_amount_input()); // 티켓 수량
				at.priority = pc.priority_string(ifc.priority_selection_input()); // 없음, 장애인, 국가유공자, 다자녀, 임산부
				at.ticket_price = pc.ticket_price_cal(at.ticket_type, at.age_checker, at.ticket_amount, at.priority);
				// 티켓 가격 계산

				at_arrlist.add(at); // 인스턴스 값을 정한 후 AmusementType형의 ArrayList에 넣어줌

				exit = ifc.loop_exit();
				if (exit == 2) {
					opc.print_total_ticket(at_arrlist);
					break;
				}
			}
			fwc.dataWrite(at_arrlist);

			exit = ifc.loop_exit2();
			if (exit == 2) {
				break;
			}
		}
		fwc.fileClose();

	}

}
