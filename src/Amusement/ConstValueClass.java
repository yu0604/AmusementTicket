package Amusement;

public class ConstValueClass {
	final static int AM_ADULT_DAY_PRICE = 56000; // 성인 주중 이용권 가격
	final static int AM_ADULT_NIGHT_PRICE = 46000; // 성인 야간 이용권 가격
	final static int AM_TEEN_DAY_PRICE = 47000; // 청소년 주중 이용권 가격
	final static int AM_TEEN_NIGHT_PRICE = 40000; // 청소년 야간 이용권 가격
	final static int AM_KID_DAY_PRICE = 44000; // 소인 주중 이용권 가격
	final static int AM_KID_NIGHT_PRICE = 37000; // 소인 야간 이용권 가격
	final static int AM_OLD_DAY_PRICE = 44000; // 노인 주중 이용권 가격
	final static int AM_OLD_NIGHT_PRICE = 37000; // 노인 야간 이용권 가격
	final static int AM_BABY_PRICE = 0; // 유아 이용권 가격

	final static double AM_NORMAL_DISCOUNT_RATE = 1.0;
	final static double AM_DISABLED_DISCOUNT_RATE = 0.6; // 장애인 할인 후 비율 (40% 할인)
	final static double AM_MERIT_DISCOUNT_RATE = 0.5; // 국가유공자 할인 후 비율 (50% 할인)
	final static double AM_MULTICHILD_DISCOUNT_RATE = 0.8; // 다자녀 할인 후 비율 (20% 할인)
	final static double AM_PREGNANT_DISCOUNT_RATE = 0.85; // 임산부 할인 후 비율 (15% 할인)
	
	final static int AM_DAY_TYPE = 1; // 주중 이용권 선택 옵션
	final static int AM_NIGHT_TYPE = 2; // 야간 이용권 선택 옵션
	
	final static int AM_NORMAL_DISCOUNT_TYPE = 1; // 옵션 번호 1 - 할인 없음
	final static int AM_DISABLE_DISCOUNT_TYPE = 2; // 옵션 번호 2 - 장애인 할인 
	final static int AM_MERIT_DISCOUNT_TYPE = 3; // 옵션 번호 3 - 국가유공자 할인
	final static int AM_MULTICHILD_DISCOUNT_TYPE = 4; // 옵션 번호 4 - 다자녀 할인
	final static int AM_PREGNANT_DISCOUNT_TYPE = 5; // 옵션 번호 5 - 임산부 할인
	
	final static int AM_BABY_AGE = 2; // 
	final static int AM_KID_AGE_MIN = 3;
	final static int AM_KID_AGE_MAX = 12;
	final static int AM_TEEN_AGE_MIN = 13;
	final static int AM_TEEN_AGE_MAX = 18;
	final static int AM_OLD_AGE = 65;
	
	final static int AM_AGE_CHECKER_BEFORE_MAN = 1;
	final static int AM_AGE_CHECKER_BEFORE_WOMAN = 2;
	final static int AM_AGE_CHECKER_AFTER_MAN = 3;
	final static int AM_AGE_CHECKER_AFTER_WOMAN = 4;
}
