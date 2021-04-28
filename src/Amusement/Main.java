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
		
		int exit = 0;
		int exit2 = 0;
		
		fwc.headerWrite();
		
		while (true) {
			at_arrlist = new ArrayList<AmusementType>();

			while (true) {
				at = new AmusementType();
				at.getDate = pc.getDate();
				at.ticket_type = pc.ticket_type(ifc.ticket_type_selection_input());
				at.age_checker = pc.age_checker(ifc.regist_number_input());
				at.ticket_amount = pc.ticket_amount(ifc.ticket_amount_input());
				at.priority = pc.priority_string(ifc.priority_selection_input());
				at.ticket_price = pc.ticket_price_cal(at.ticket_type, at.age_checker, at.ticket_amount, at.priority);
				at_arrlist.add(at);

				exit = ifc.loop_exit();
				if (exit == 2) {
					opc.print_total_ticket(at_arrlist);
					break;
				}
			}
			fwc.dataWrite(at_arrlist);
			
			exit2 = ifc.loop_exit2();
			if (exit2 == 2) {
				break;
			}
		}
		fwc.fileClose();

	}

}
