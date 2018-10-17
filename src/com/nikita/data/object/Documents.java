package com.nikita.data.object;

import java.sql.Date;

public class Documents {
	private int f_id;
	private String f_number;
	private String f_sender_name;
	private String f_recip_name;
	private Date f_date;
	private float f_sum;
	private String f_state_name;
	
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_sender_name() {
		return f_sender_name;
	}
	public void setF_sender_name(String f_sender_name) {
		this.f_sender_name = f_sender_name;
	}
	public Date getF_date() {
		return f_date;
	}
	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	public String getF_recip_name() {
		return f_recip_name;
	}
	public void setF_recip_name(String f_recip_name) {
		this.f_recip_name = f_recip_name;
	}
	public float getF_sum() {
		return f_sum;
	}
	public void setF_sum(float f_sum) {
		this.f_sum = f_sum;
	}
	public String getF_state_name() {
		return f_state_name;
	}
	public void setF_state_name(String f_state_name) {
		this.f_state_name = f_state_name;
	}
	public String getF_number() {
		return f_number;
	}
	public void setF_number(String f_number) {
		this.f_number = f_number;
	}

}
