package Analysis;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReaderAnalysis fa = new FileReaderAnalysis();
		ProcessingClass pc = new ProcessingClass();
		OutputClass oc = new OutputClass();
		FileWriteClassForAnalysis fwc = new FileWriteClassForAnalysis();

		oc.printFile(pc.IntegerTicketType(fa.FileReadForAnalysis())); // ArrayList<String[]>
		oc.ticketTypeDay(pc.ticketTypeMakeArr(fa.FileReadForAnalysis())); // int [][]
		oc.dailysalePrint(pc.DailySaleArr(fa.FileReadForAnalysis(), pc.removeDuplicateDate(0))); // int [][]
		oc.priorityPrint(pc.priorityMakeArr(fa.FileReadForAnalysis())); // int []
		
		// Write File
		fwc.fileOpenDaily();
		fwc.headerWriteDaily();
		fwc.dataWriteDaily(pc.DailySaleArr(fa.FileReadForAnalysis(), pc.removeDuplicateDate(0)));
		fwc.fileClose();

		fwc.fileOpenTicketType();
		fwc.headerWriteTicketType();
		fwc.dataWriteTicketType(pc.ticketTypeMakeArr(fa.FileReadForAnalysis()));
		fwc.fileClose();

		fwc.fileOpenPriority();
		fwc.headerWritePriority();
		fwc.dataWritePriority(pc.priorityMakeArr(fa.FileReadForAnalysis()));
		fwc.fileClose();
	}
}
