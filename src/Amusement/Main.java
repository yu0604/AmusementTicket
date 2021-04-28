package Amusement;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		InputFromConsole ifc = new InputFromConsole();
		ProcessingClass pc = new ProcessingClass();
		ArrayList<AmusementType> at_arrlist = new ArrayList<AmusementType>();
		AmusementType at;

		while (true) {
			int i = 0;
			while (true) {
				at = new AmusementType();
				at.getDate = pc.getDate();
				at.ticket_type = pc.ticket_type(ifc.ticket_type_selection_input());
				at.age_checker = pc.age_checker(ifc.regist_number_input());
				at.ticket_amount = pc.ticket_amount(ifc.ticket_amount_input());
				at.priority = pc.priority_string(ifc.priority_selection_input());
				at.ticket_price = pc.ticket_price_cal(at.ticket_type, at.age_checker, at.ticket_amount, at.priority);
				// AmusementType의 생성자
				at_arrlist.add(at);
				System.out.println(at_arrlist.get(i).ticket_price);
				i++;
				if (i == 2) {
					break;
				}
			}
			break;
		}

	}

}
