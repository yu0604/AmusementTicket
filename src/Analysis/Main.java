package Analysis;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReaderAnalysis fa = new FileReaderAnalysis();
		ProcessingClass pc = new ProcessingClass();
		OutputClass oc = new OutputClass();

		ArrayList<String[]> arrstr = new ArrayList<String[]>();

		oc.printFile(pc.IntegerTicketType(fa.FileReadForAnalysis())); // ArrayList<String[]>
		oc.ticketTypeDay(pc.ticketTypeMakeArr(fa.FileReadForAnalysis())); // int [][]
		oc.dailysalePrint(pc.DailySaleArr(fa.FileReadForAnalysis(), pc.removeDuplicateDate(0))); // int [][]
		oc.priorityPrint(pc.priorityMakeArr(fa.FileReadForAnalysis())); // int []
	}

}
