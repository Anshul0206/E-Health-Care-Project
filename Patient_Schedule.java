

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
 * Servlet implementation class Patient_Schedule
 */
@WebServlet("/Patient_Schedule")
public class Patient_Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_Schedule() {
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
		String name=request.getParameter("name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select* from shedule_appointment");
			while(rs.next())
			{
				String p_name=rs.getString(1);
				String p_problem=rs.getString(2);
				String p_status=rs.getString(3);
				String ad=rs.getString(4);
				String ds=rs.getString(5);
				String dr=rs.getString(6);
				String apd=rs.getString(7);
				String cs=rs.getString(8);
				if(p_name.equals(name))
				{
					out.print("<table>" +
							"<tr>" +
							"<th>Name</th>" +
							"<th>Problem</th>" +
							"<th>Status</th>" +
							"<th>Doctor</th>" +
							"<th>Doctor Specification</th>" +
							"<th>Doctor Role</th>" +
							"<th>Appointment Date</th>" +
							"<th>Confirmation Status</th>" +
							"</tr>" +
							"<tr>" +
							"<td>"+p_name+"</td>"+
							"<td>"+p_problem+"</td>"+
							"<td>"+p_status+"</td>"+
							"<td>"+ad+"</td>"+
							"<td>"+ds+"</td>"+
							"<td>"+dr+"</td>"+
							"<td>"+apd+"</td>"+
							"<td>"+cs+"</td>"+
							"</tr>"+
							"</table>"
							);
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
