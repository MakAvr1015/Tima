package wNikita;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DocList {

	private static String GET_OUT_DOCS = "";
	private static String GET_IN_DOCS = "select f_id,f_number,f_date,f_state,f_state_name,f_partner,f_partner_name, f_doc_count,f_doc_sum\n"
			+ "from SP_T_DOC_IN_S(1,?,?)";
	private static String GET_MOVE_DOCS = "";
	private static String GET_SALE_DOCS = "select f_id,f_number,f_date,f_state,f_state_name,f_partner,f_partner_name, f_doc_count,f_doc_sum\n"
			+ "from SP_T_DOC_OUT_S(1,?,?)";
	private DataSource ds;
	private Connection conn;

	public DocList() {
		InitList();

	}

	private void InitList() {
		// TODO Auto-generated method stub
		try {
			Context ctx = (Context) new InitialContext();
			ds = ((DataSource) ((InitialContext) ctx).lookup("java:comp/env/jdbc/nbase"));
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public MoveDocument[] getList(int docType, Calendar date_beg, Calendar date_end) {
		List<MoveDocument> docs;
		docs = new ArrayList<MoveDocument>();
		String get_listDocs;
		Date p_par;
		switch (docType) {
		case 1:
			get_listDocs = GET_IN_DOCS;
			break;
		case 2:
			get_listDocs = GET_SALE_DOCS;
			break;
		default:
			get_listDocs = GET_IN_DOCS;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(get_listDocs);
			p_par = new Date(date_beg.getTime().getTime());
			stmt.setDate(1, p_par);
			p_par = new Date(date_end.getTime().getTime());
			stmt.setDate(2, p_par);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				docs.add(new MoveDocument(rs.getInt("F_ID"), rs.getString("f_number"), rs.getDate("f_date"),
						rs.getInt("F_state"), rs.getString("f_state_name"), rs.getInt("f_partner"),
						rs.getString("f_partner_name"), 0, ""));

			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MoveDocument[] dList = new MoveDocument[docs.size()];
//		 System.out.println(String.valueOf());
		int i = 0;
		for (MoveDocument pos : docs) {
			dList[i] = pos;
			i++;
		}
		return dList;

	}

}
