package com.nikita.data.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nikita.data.object.Documents;
import com.nikita.data.object.RestPosition;

public class NikitaDataService {

	private static NikitaDataService NS;

	private static String GET_OUT_DOCS = "select f_id,f_number,f_date,f_state,f_state_name,f_partner,f_partner_name, f_doc_count,f_doc_sum,f_sklad_name\n"
			+ "from SP_T_DOC_OUT_S(1,?,?)";

	private static Connection connection;
	private static DataSource ds;

	public static synchronized NikitaDataService getNS() {
		if (NS == null) {
			NS = new NikitaDataService();
			try {
				Context ctx = (Context) new InitialContext();
				ds = ((DataSource) ((InitialContext) ctx).lookup("java:comp/env/jdbc/nbase"));
				connection = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return NS;
	}

	public void setConnection(Connection con) {
		if (connection == null) {
			connection = con;
		}

	}

	public static List<RestPosition> getRest() {
		// TODO Auto-generated method stub
		List<RestPosition> listRest = new ArrayList<RestPosition>();
		RestPosition aPosition;
		for (int i = 0; i < 2000; i++) {
			aPosition = new RestPosition();
			aPosition.setF_article("АРТИКУЛ_" + String.valueOf(i));
			aPosition.setF_name("Товар " + String.valueOf(i));
			aPosition.setF_quant(100 + i);
			listRest.add(aPosition);
		}

		return listRest;
	}

	public List<Documents> getOutDocs(Date p_date) {
		PreparedStatement stmt = null;
		List<Documents> listOutDocs = new ArrayList<Documents>();
		try {
			stmt = connection.prepareStatement(GET_OUT_DOCS);
			Calendar c = Calendar.getInstance();
			c.setTime(p_date);
			c.add(Calendar.DATE, -1);
			stmt.setDate(1, new Date(c.getTimeInMillis()));
			stmt.setDate(2, p_date);
			ResultSet rs = stmt.executeQuery();
			Documents doc;

			while (rs.next()) {
				doc = new Documents();
				doc.setF_id(rs.getInt("f_id"));
				doc.setF_number(rs.getString("f_number"));
				doc.setF_date(rs.getDate("f_date"));
				
				doc.setF_recip_name((rs.getString("f_partner_name")!=null)?rs.getString("f_partner_name"):"--Empty--");
				doc.setF_sender_name(rs.getString("f_sklad_name"));
				doc.setF_state_name(rs.getString("f_state_name"));
				doc.setF_sum(rs.getLong("f_doc_sum"));
				listOutDocs.add(doc);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOutDocs;
	}

}
