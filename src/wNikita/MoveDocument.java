package wNikita;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MoveDocument {
	public int f_id;
	public String f_number;
	public Calendar f_date;
	public int f_state;
	public String f_state_name;
	public Partner f_sender;
	public Partner f_recipient;
	
	public MoveDocument() {
		
	}
	public MoveDocument(int p_id, String p_number, Date p_date,int p_state, String p_stateName, int p_sender, String p_sender_name,
			int p_recipient, String p_recipient_name) {
		f_id = p_id;
		f_number = p_number;
		f_date = Calendar.getInstance();
		f_date.setTime(p_date);
		f_state=p_state;
		f_state_name=p_stateName;
		if (p_sender > 0) {
			f_sender = new Partner(p_sender, p_sender_name);
		}
		if (p_recipient > 0) {
			f_recipient=new Partner(p_recipient,p_recipient_name);
		}

	}
	public GoodPosition[] GetGoodList() {
		List<GoodPosition> goods;
		goods = new ArrayList<GoodPosition>();		
		return null;
		
	}

}
