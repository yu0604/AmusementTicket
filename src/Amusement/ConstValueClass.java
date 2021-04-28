package Amusement;

public class ConstValueClass {
	final static int AM_ADULT_DAY_PRICE = 56000; // ���� ���� �̿�� ����
	final static int AM_ADULT_NIGHT_PRICE = 46000; // ���� �߰� �̿�� ����
	final static int AM_TEEN_DAY_PRICE = 47000; // û�ҳ� ���� �̿�� ����
	final static int AM_TEEN_NIGHT_PRICE = 40000; // û�ҳ� �߰� �̿�� ����
	final static int AM_KID_DAY_PRICE = 44000; // ���� ���� �̿�� ����
	final static int AM_KID_NIGHT_PRICE = 37000; // ���� �߰� �̿�� ����
	final static int AM_OLD_DAY_PRICE = 44000; // ���� ���� �̿�� ����
	final static int AM_OLD_NIGHT_PRICE = 37000; // ���� �߰� �̿�� ����
	final static int AM_BABY_PRICE = 0; // ���� �̿�� ����

	final static double AM_NORMAL_DISCOUNT_RATE = 1.0;
	final static double AM_DISABLED_DISCOUNT_RATE = 0.6; // ����� ���� �� ���� (40% ����)
	final static double AM_MERIT_DISCOUNT_RATE = 0.5; // ���������� ���� �� ���� (50% ����)
	final static double AM_MULTICHILD_DISCOUNT_RATE = 0.8; // ���ڳ� ���� �� ���� (20% ����)
	final static double AM_PREGNANT_DISCOUNT_RATE = 0.85; // �ӻ�� ���� �� ���� (15% ����)
	
	final static int AM_DAY_TYPE = 1; // ���� �̿�� ���� �ɼ�
	final static int AM_NIGHT_TYPE = 2; // �߰� �̿�� ���� �ɼ�
	
	final static int AM_NORMAL_DISCOUNT_TYPE = 1; // �ɼ� ��ȣ 1 - ���� ����
	final static int AM_DISABLE_DISCOUNT_TYPE = 2; // �ɼ� ��ȣ 2 - ����� ���� 
	final static int AM_MERIT_DISCOUNT_TYPE = 3; // �ɼ� ��ȣ 3 - ���������� ����
	final static int AM_MULTICHILD_DISCOUNT_TYPE = 4; // �ɼ� ��ȣ 4 - ���ڳ� ����
	final static int AM_PREGNANT_DISCOUNT_TYPE = 5; // �ɼ� ��ȣ 5 - �ӻ�� ����
	
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
