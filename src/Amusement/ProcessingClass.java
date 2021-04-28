package Amusement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProcessingClass {
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");

	public String getDate() { // 현재 시간 출력 메소드
		return sdf.format(c.getTime());
	}

	public String ticket_type(int ticket_type_selection) {
		// 주간권, 야간권을 정하기 위한 메소드
		String ticket_type = "";
		if (ticket_type_selection == ConstValueClass.AM_DAY_TYPE) {
			ticket_type = "주간권";
		} else {
			ticket_type = "야간권";
		}
		return ticket_type;
	}

	public String age_checker(String regist_number) {
		String today = getDate(); // 오늘 날짜를 저장하는 문자열
		String age_checker = ""; 
		// 유아, 소인, 청소년, 대인, 노인을 구분하기 위한 문자열
		// 해당 메소드의 리턴값

		int year_today = Integer.parseInt(today.substring(0, 4)); // 오늘 날짜의 연도
		int month_today = Integer.parseInt(today.substring(4, 6)); // 오늘 날짜의 월
		int day_today = Integer.parseInt(today.substring(6, 8)); // 오늘 날짜의 일

		int year = 0; // 주민등록번호의 연도
		int month = 0; // 주민등록번호의 월
		int day = 0; // 주민등록번호의 일
		int age = 0; // 나이 값을 이용해 노인 / 청소년 / 소인 / 어른 구분

		if (regist_number.charAt(6) == '3' || regist_number.charAt(6) == '4') {
			year = 2000 + Integer.parseInt(regist_number.substring(0, 2));
			// ex) 2000 + 19 = 2019
		} else if (regist_number.charAt(6) == '1' || regist_number.charAt(6) == '2') {
			year = 1900 + Integer.parseInt(regist_number.substring(0, 2));
			// ex) 1900 + 91 = 1991
		}
		
		month = Integer.parseInt(regist_number.substring(2, 4)); // 주민등록번호 상의 월
		day = Integer.parseInt(regist_number.substring(4, 6)); // 주민등록번호 상의 일
		
		// 아래 연산에 대한 설명
		// Ex) 2021 04 28           2021 04                                    2021 
		//     1991 04 30   ----->  1991 05                           ----->   1992                      -----> 만 나이 29로 계산
		//                          28 - 30 < 0 이므로 월을 1 올려줌               4 - 5 < 0 이므로 연을 1 올려줌
		//
		//  만 나이를 계산하기 위한 연산이기에 월, 일 계산이 끝나는 경우 해당 단위는 신경쓸 필요 없음

		if (day_today - day < 0) {
			month++;
		}

		if (month_today - month < 0) {
			year++;
		}

		age = year_today - year;
		
		// 나이에 따른 연령구분
		if (age <= ConstValueClass.AM_BABY_AGE) {
			age_checker = "유아";
		} else if (age >= ConstValueClass.AM_KID_AGE_MIN && age <= ConstValueClass.AM_KID_AGE_MAX) {
			age_checker = "소인";
		} else if (age >= ConstValueClass.AM_TEEN_AGE_MIN && age <= ConstValueClass.AM_TEEN_AGE_MAX) {
			age_checker = "청소년";
		} else if (age >= ConstValueClass.AM_OLD_AGE) {
			age_checker = "노인";
		} else {
			age_checker = "대인";
		}

		return age_checker; // 유아, 소인, 청소년, 대인, 노인 중 1개 리턴
	}

	public int ticket_amount(int ticket_amount) {
		return ticket_amount; // 티켓 수량 리턴 메소드
	}

	public int ticket_price_day(String age_checker) {
		// 주간권인 경우 나이에 따른 가격 설정 메소드
		int ticket_price_day = 0;
		if (age_checker.equals("유아")) {
			ticket_price_day = ConstValueClass.AM_BABY_PRICE;
		} else if (age_checker.equals("소인")) {
			ticket_price_day = ConstValueClass.AM_KID_DAY_PRICE;
		} else if (age_checker.equals("청소년")) {
			ticket_price_day = ConstValueClass.AM_TEEN_DAY_PRICE;
		} else if (age_checker.equals("노인")) {
			ticket_price_day = ConstValueClass.AM_OLD_DAY_PRICE;
		} else {
			ticket_price_day = ConstValueClass.AM_ADULT_DAY_PRICE;
		}
		return ticket_price_day;
	}

	public int ticket_price_night(String age_checker) {
		// 야간권인 경우 나이에 따른 가격 설정 메소드
		int ticket_price_night = 0;
		if (age_checker.equals("유아")) {
			ticket_price_night = ConstValueClass.AM_BABY_PRICE;
		} else if (age_checker.equals("소인")) {
			ticket_price_night = ConstValueClass.AM_KID_NIGHT_PRICE;
		} else if (age_checker.equals("청소년")) {
			ticket_price_night = ConstValueClass.AM_TEEN_NIGHT_PRICE;
		} else if (age_checker.equals("노인")) {
			ticket_price_night = ConstValueClass.AM_OLD_NIGHT_PRICE;
		} else {
			ticket_price_night = ConstValueClass.AM_ADULT_NIGHT_PRICE;
		}
		return ticket_price_night;
	}

	public double ticket_sale_for_priority(String priority) {
		double sale_rate = ConstValueClass.AM_NORMAL_DISCOUNT_RATE;
		if (priority.equals("없음")) {
			sale_rate = ConstValueClass.AM_NORMAL_DISCOUNT_RATE;
		} else if (priority.equals("장애인")) {
			sale_rate = ConstValueClass.AM_DISABLED_DISCOUNT_RATE;
		} else if (priority.equals("국가유공자")) {
			sale_rate = ConstValueClass.AM_MERIT_DISCOUNT_RATE;
		} else if (priority.equals("다자녀")) {
			sale_rate = ConstValueClass.AM_MULTICHILD_DISCOUNT_RATE;
		} else if (priority.equals("임산부")) {
			sale_rate = ConstValueClass.AM_PREGNANT_DISCOUNT_RATE;
		}

		return sale_rate;
	}
	
	public int ticket_price_cal(String ticket_type, String age_checker, int ticket_amount, String priority) {
		// 티켓 가격 계산 메소드
		int ticket_price = 0;
		if (ticket_type.equals("주간권")) {
			// 주간권인 경우 나이에 따라 주간권 가격을 설정한 메소드를 호출
			ticket_price = ticket_price_day(age_checker);
		} else {
			// 야간권인 경우 나이에 따라 야간권 가격을 설정한 메소드를 호출
			ticket_price = ticket_price_night(age_checker);
		}

		ticket_price = (int) (ticket_price * ticket_amount * ticket_sale_for_priority(priority));
		// 티켓 가격을 기준 가격에 수량, 우대할인율을 곱한 가격으로 결정함
		
		return ticket_price;
	}

	public String priority_string(int priority_selection) {
		// 우대사항에 대한 문자열을 리턴하는 메소드
		String priority = "";

		if (priority_selection == ConstValueClass.AM_NORMAL_DISCOUNT_TYPE) {
			priority = "없음";
		} else if (priority_selection == ConstValueClass.AM_DISABLE_DISCOUNT_TYPE) {
			priority = "장애인";
		} else if (priority_selection == ConstValueClass.AM_MERIT_DISCOUNT_TYPE) {
			priority = "국가유공자";
		} else if (priority_selection == ConstValueClass.AM_MULTICHILD_DISCOUNT_TYPE) {
			priority = "다자녀";
		} else if (priority_selection == ConstValueClass.AM_PREGNANT_DISCOUNT_TYPE) {
			priority = "임산부";
		}

		return priority;
	}

}
