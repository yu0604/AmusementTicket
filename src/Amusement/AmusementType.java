package Amusement;

public class AmusementType {
	String getDate;
	String ticket_type;
	String age_checker;
	int ticket_amount;
	int ticket_price;
	String priority;
	int total_ticket_price;

	AmusementType(String getDate, String ticket_type, String age_checker, int ticket_amount, int ticket_price,
			String priority, int total_ticket_price) {
		this.getDate = getDate;
		this.ticket_type = ticket_type;
		this.age_checker = age_checker;
		this.ticket_amount = ticket_amount;
		this.ticket_price = ticket_price;
		this.priority = priority;
		this.total_ticket_price = total_ticket_price;
	}
}
