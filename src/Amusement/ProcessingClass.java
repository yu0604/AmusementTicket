package Amusement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
	

	public String getDate() {
		return sdf.format(c.getTime());
	}

	public String ticket_type(int ticket_type_selection) {
		String ticket_type = "";
		if (ticket_type_selection == ConstValueClass.AM_DAY_TYPE) {
			ticket_type = "�ְ���";
		} else {
			ticket_type = "�߰���";
		}
		return ticket_type;
	}

	public String age_checker(String regist_number) {
		String today = getDate(); // ���� ��¥�� �����ϴ� ���ڿ�
		String age_checker = "";

		int year_today = Integer.parseInt(today.substring(0, 4));
		int month_today = Integer.parseInt(today.substring(4, 6));
		int day_today = Integer.parseInt(today.substring(6, 8));

		int year = 0; // �ֹε�Ϲ�ȣ�� ����
		int month = 0; // �ֹε�Ϲ�ȣ�� ��
		int day = 0; // �ֹε�Ϲ�ȣ�� ��
		int age = 0; // ���̸� �̿��� ���� / û�ҳ� / ���� / � ����

		if (regist_number.charAt(6) == '3' || regist_number.charAt(6) == '4') {
			year = 2000 + Integer.parseInt(regist_number.substring(0, 2));
			// ex) 2000 + 19
		} else if (regist_number.charAt(6) == '1' || regist_number.charAt(6) == '2') {
			year = 1900 + Integer.parseInt(regist_number.substring(0, 2));
			// ex) 1900 + 91
		}

		if (day_today - Integer.parseInt(regist_number.substring(4, 6)) < 0) {
			month++;
		}

		if (month_today - Integer.parseInt(regist_number.substring(2, 4)) < 0) {
			year++;
		}

		age = year_today - year;

		if (age <= ConstValueClass.AM_BABY_AGE) {
			age_checker = "����";
		} else if (age >= ConstValueClass.AM_KID_AGE_MIN && age <= ConstValueClass.AM_KID_AGE_MAX) {
			age_checker = "����";
		} else if (age >= ConstValueClass.AM_TEEN_AGE_MIN && age <= ConstValueClass.AM_TEEN_AGE_MAX) {
			age_checker = "û�ҳ�";
		} else if (age >= ConstValueClass.AM_OLD_AGE) {
			age_checker = "����";
		} else {
			age_checker = "����";
		}

		return age_checker;
	}
	
	public int ticket_amount(int ticket_amount) {
		return ticket_amount;
	}
	
	public String priority_string(int priority_selection) {
		String priority = "";
		
		if (priority_selection == ConstValueClass.AM_NORMAL_DISCOUNT_TYPE) {
			priority = "����";
		} else if (priority_selection == ConstValueClass.AM_DISABLE_DISCOUNT_TYPE) {
			priority = "�����";
		} else if (priority_selection == ConstValueClass.AM_MERIT_DISCOUNT_TYPE) {
			priority = "����������";
		} else if (priority_selection == ConstValueClass.AM_MULTICHILD_DISCOUNT_TYPE) {
			priority = "���ڳ�";
		} else if (priority_selection == ConstValueClass.AM_PREGNANT_DISCOUNT_TYPE) {
			priority = "�ӻ��";
		}
		
		return priority;
	}

}
