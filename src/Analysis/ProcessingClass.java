package Analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ProcessingClass {
	FileReaderAnalysis fa = new FileReaderAnalysis();

	public ArrayList<String> removeDuplicateDate(int col_number) throws IOException {
		// �� ��ȣ�� input���� �޾Ƽ� �ش� ���� �ߺ������� �� �ش� arraylist�� ����
		ArrayList<String[]> arr_str = fa.FileReadForAnalysis();
		HashSet<String> hash_remove_dup = new HashSet<String>();
		ArrayList<String> arr_remove_dup = new ArrayList<String>();

		for (int i = 1; i < arr_str.size(); i++) {
			hash_remove_dup.add(arr_str.get(i)[col_number]);
		}

		Iterator<String> iterator = hash_remove_dup.iterator();

		while (iterator.hasNext()) {
			arr_remove_dup.add(iterator.next());
		}

		Collections.sort(arr_remove_dup);
		
		return arr_remove_dup;
	}

	public ArrayList<String[]> IntegerTicketType(ArrayList<String[]> arr_str) {
		String[] temparr = new String[arr_str.size()];

		for (int i = 1; i < arr_str.size(); i++) {
			temparr = arr_str.get(i);
			if (arr_str.get(i)[1].equals("�ְ���")) {
				temparr[1] = "1";
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[1].equals("�߰���")) {
				temparr[1] = "2";
				arr_str.set(i, temparr);
			}

			if (arr_str.get(i)[2].equals("����")) {
				temparr[2] = Integer.toString(ConstValueClass.AM_BABY);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[2].equals("���")) {
				temparr[2] = Integer.toString(ConstValueClass.AM_CHILD);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[2].equals("û�ҳ�")) {
				temparr[2] = Integer.toString(ConstValueClass.AM_TEEN);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[2].equals("�")) {
				temparr[2] = Integer.toString(ConstValueClass.AM_ADULT);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[2].equals("����")) {
				temparr[2] = Integer.toString(ConstValueClass.AM_OLD);
				arr_str.set(i, temparr);
			}

			if (arr_str.get(i)[5].equals("����")) {
				temparr[5] = Integer.toString(ConstValueClass.AM_NONE);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[5].equals("�����")) {
				temparr[5] = Integer.toString(ConstValueClass.AM_DISABLE);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[5].equals("����������")) {
				temparr[5] = Integer.toString(ConstValueClass.AM_MERIT);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[5].equals("���ڳ�")) {
				temparr[5] = Integer.toString(ConstValueClass.AM_MULTICHILD);
				arr_str.set(i, temparr);
			} else if (arr_str.get(i)[5].equals("�ӻ��")) {
				temparr[5] = Integer.toString(ConstValueClass.AM_PREGNANT);
				arr_str.set(i, temparr);
			}
		}
		return arr_str;
	}

	public int[][] ticketTypeMakeArr(ArrayList<String[]> arr_str) {
		// ���Ͽ��� �޾ƿ� ģ���� �ߺ������� ģ���� ���ؼ� ���Ұ���
		int[][] ticketTypeArr = new int[7][2];
		for (int i = 1; i < arr_str.size(); i++) {
			if (arr_str.get(i)[1].equals("�ְ���")) {
				if (arr_str.get(i)[2].equals("����")) {
					ticketTypeArr[ConstValueClass.AM_BABY - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("���")) {
					ticketTypeArr[ConstValueClass.AM_CHILD - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("û�ҳ�")) {
					ticketTypeArr[ConstValueClass.AM_TEEN - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("�")) {
					ticketTypeArr[ConstValueClass.AM_ADULT - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("����")) {
					ticketTypeArr[ConstValueClass.AM_OLD - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				}
				ticketTypeArr[ConstValueClass.AM_TOTAL_AMOUNT - 1][0] += Integer.parseInt(arr_str.get(i)[3]);
				ticketTypeArr[ConstValueClass.AM_TOTAL_PRICE - 1][0] += Integer.parseInt(arr_str.get(i)[4]);
			} else {
				if (arr_str.get(i)[2].equals("����")) {
					ticketTypeArr[ConstValueClass.AM_BABY - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("���")) {
					ticketTypeArr[ConstValueClass.AM_CHILD - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("û�ҳ�")) {
					ticketTypeArr[ConstValueClass.AM_TEEN - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("�")) {
					ticketTypeArr[ConstValueClass.AM_ADULT - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				} else if (arr_str.get(i)[2].equals("����")) {
					ticketTypeArr[ConstValueClass.AM_OLD - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				}
				ticketTypeArr[ConstValueClass.AM_TOTAL_AMOUNT - 1][1] += Integer.parseInt(arr_str.get(i)[3]);
				ticketTypeArr[ConstValueClass.AM_TOTAL_PRICE - 1][1] += Integer.parseInt(arr_str.get(i)[4]);
			}
		}
		return ticketTypeArr;
	}

	public int[] priorityMakeArr(ArrayList<String[]> arr_str) {
		int[] priorityArr = new int[6];
		for (int i = 1; i < arr_str.size(); i++) {
			if (arr_str.get(i)[5].contains("����")) {
				priorityArr[ConstValueClass.AM_NONE] += Integer.parseInt(arr_str.get(i)[3]);
			} else if (arr_str.get(i)[5].contains("�����")) {
				priorityArr[ConstValueClass.AM_DISABLE] += Integer.parseInt(arr_str.get(i)[3]);
			} else if (arr_str.get(i)[5].contains("����������")) {
				priorityArr[ConstValueClass.AM_MERIT] += Integer.parseInt(arr_str.get(i)[3]);
			} else if (arr_str.get(i)[5].contains("���ڳ�")) {
				priorityArr[ConstValueClass.AM_MULTICHILD] += Integer.parseInt(arr_str.get(i)[3]);
			} else if (arr_str.get(i)[5].contains("�ӻ��")) {
				priorityArr[ConstValueClass.AM_PREGNANT] += Integer.parseInt(arr_str.get(i)[3]);
			}
			priorityArr[0] += Integer.parseInt(arr_str.get(i)[3]);
		}
		return priorityArr;
	}
	
	public int[][] DailySaleArr(ArrayList<String[]> arr_str, ArrayList<String> arr_remove_dup){
		int [][] dailysaleArr = new int [arr_remove_dup.size()][2];
		
		for(int i = 0; i < arr_remove_dup.size(); i++) {
			for(int j = 0; j < arr_str.size(); j++) {
				if (arr_remove_dup.get(i).equals(arr_str.get(j)[0])) {
					dailysaleArr[i][1] += Integer.parseInt(arr_str.get(j)[4]);
				}
			}
			dailysaleArr[i][0] = Integer.parseInt(arr_remove_dup.get(i));
		}
		
		return dailysaleArr;
	}

}
