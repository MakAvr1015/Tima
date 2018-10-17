package com.nikita.data.object;

import java.util.List;

public class DataTableObject {
	private int iTotalRecords;
	private int iTotalDisplayRecords;
	String sEcho;
	String sColumns;
	List<Documents> aaData;

	private int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	private int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public List<Documents> getAaData() {
		return aaData;
	}

	public void setAaData(List<Documents> aaData) {
		setiTotalRecords(aaData.size());
		if (aaData.size()>100) {
			setiTotalDisplayRecords(100);
		} else
		{
			setiTotalDisplayRecords(aaData.size());
		}
		
		this.aaData = aaData;
	}

}
