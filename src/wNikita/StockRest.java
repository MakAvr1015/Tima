package wNikita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;





public class StockRest {
//	private List<GoodPosition> listRests;
	private DataSource ds;
	private Connection conn;
	private static String GET_OST="select f_id,f_article,f_name,f_count,f_price1 from PR_GET_OST_FOR_SITE";
	public StockRest() {
		initRest();
		
	}

	private void initRest() {
		// TODO Auto-generated method stub
	    try {		
    	Context ctx = (Context) new InitialContext();
    	ds = ((DataSource) ((InitialContext) ctx).lookup("java:comp/env/jdbc/nbase"));
        conn = ds.getConnection();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
		
//		listRests=new ArrayList<GoodPosition>();

		
	}
	
	public GoodPosition[] getRest() {
		List<GoodPosition> rest;
		rest = new ArrayList<GoodPosition>();
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
	        ResultSet rs = stmt.executeQuery(GET_OST);

	        while (rs.next()) {
	        	rest.add(
	        	new GoodPosition(rs.getInt("f_id"),rs.getString("f_name"),rs.getString("f_article"),rs.getInt("f_count"),rs.getFloat("f_price1") )
	        			);
	        	
	        	
	        }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GoodPosition[] rests=new GoodPosition[rest.size()];
		int i=0;
		for(GoodPosition pos : rest) {
			rests[i]=pos;
			i++;
		}
		return rests;
		
	}
	public String checkDb() {
		String result = null;
	    Statement stmt = null;
	        try {
				stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM T_NSI_SKLAD");
		        while (rs.next()) {
		            System.out.println(rs.getString("f_name"));
		        }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //SQL data fetch using the connection
//	        conn.close();
//	        conn = null;
	    
	    return result;
	}
	

}
