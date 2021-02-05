

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Patient_Report
 */
@WebServlet("/Patient_Report")
public class Patient_Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String p_name=request.getParameter("p_name");
		String date=request.getParameter("date");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select* from patient_report");
			while(rs.next())
			{
				String name=rs.getString(1);
				String problem=rs.getString(2);
				String status=rs.getString(3);
				String da=rs.getString(4);
				if(name.equals(p_name) && da.equals(date))
				{
					out.print("<table>" +
							"<tr>" +
							"<th>Patient Name</th>" +
							"<th>Patient Problem</th>" +
							"<th>Patient Status</th>" +
							"<th>Date</th>" +
							"</tr>" +
							"<tr>" +
							"<td>"+name+"</td>"+
							"<td>"+problem+"</td>"+
							"<td>"+status+"</td>"+
							"<td>"+da+"</td>"+
							"</tr>"+
							"</table>");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
