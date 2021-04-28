package Amusement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");

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
		
		month = Integer.parseInt(regist_number.substring(2, 4));
		day = Integer.parseInt(regist_number.substring(4, 6));

		if (day_today - day < 0) {
			month++;
		}

		if (month_today - month < 0) {
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

	public int ticket_price_cal(String ticket_type, String age_checker, int ticket_amount, String priority) {
		int ticket_price = 0;
		if (ticket_type.equals("�ְ���")) {
			ticket_price = ticket_price_day(age_checker);
		} else {
			ticket_price = ticket_price_night(age_checker);
		}

		ticket_price = (int) (ticket_price * ticket_amount * ticket_sale_for_priority(priority));
		return ticket_price;
	}

	public int ticket_price_day(String age_checker) {
		int ticket_price_day = 0;
		if (age_checker.equals("����")) {
			ticket_price_day = ConstValueClass.AM_BABY_PRICE;
		} else if (age_checker.equals("����")) {
			ticket_price_day = ConstValueClass.AM_KID_DAY_PRICE;
		} else if (age_checker.equals("û�ҳ�")) {
			ticket_price_day = ConstValueClass.AM_TEEN_DAY_PRICE;
		} else if (age_checker.equals("����")) {
			ticket_price_day = ConstValueClass.AM_OLD_DAY_PRICE;
		} else {
			ticket_price_day = ConstValueClass.AM_ADULT_DAY_PRICE;
		}
		return ticket_price_day;
	}

	public int ticket_price_night(String age_checker) {
		int ticket_price_night = 0;
		if (age_checker.equals("����")) {
			ticket_price_night = ConstValueClass.AM_BABY_PRICE;
		} else if (age_checker.equals("����")) {
			ticket_price_night = ConstValueClass.AM_KID_NIGHT_PRICE;
		} else if (age_checker.equals("û�ҳ�")) {
			ticket_price_night = ConstValueClass.AM_TEEN_NIGHT_PRICE;
		} else if (age_checker.equals("����")) {
			ticket_price_night = ConstValueClass.AM_OLD_NIGHT_PRICE;
		} else {
			ticket_price_night = ConstValueClass.AM_ADULT_NIGHT_PRICE;
		}
		return ticket_price_night;
	}

	public double ticket_sale_for_priority(String priority) {
		double sale_rate = ConstValueClass.AM_NORMAL_DISCOUNT_RATE;
		if (priority.equals("����")) {
			sale_rate = ConstValueClass.AM_NORMAL_DISCOUNT_RATE;
		} else if (priority.equals("�����")) {
			sale_rate = ConstValueClass.AM_DISABLED_DISCOUNT_RATE;
		} else if (priority.equals("����������")) {
			sale_rate = ConstValueClass.AM_MERIT_DISCOUNT_RATE;
		} else if (priority.equals("���ڳ�")) {
			sale_rate = ConstValueClass.AM_MULTICHILD_DISCOUNT_RATE;
		} else if (priority.equals("�ӻ��")) {
			sale_rate = ConstValueClass.AM_PREGNANT_DISCOUNT_RATE;
		}

		return sale_rate;
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
