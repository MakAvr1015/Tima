package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nikita.data.object.DataTableObject;
import com.nikita.data.object.Documents;

import com.nikita.data.service.NikitaDataService;

/**
 * Servlet implementation class DocList
 */
public class DocList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=windows-1251");

		PrintWriter out = response.getWriter();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		NikitaDataService ns=NikitaDataService.getNS();

//		List<RestPosition> listData=NikitaDataService.getRest();
		GregorianCalendar cDate=new GregorianCalendar();
		List<Documents> listDocs=ns.getOutDocs(new Date(cDate.getTimeInMillis()));
		DataTableObject dto = new DataTableObject();
		dto.setAaData(listDocs);
		String json=gson.toJson(dto);
		out.print(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
