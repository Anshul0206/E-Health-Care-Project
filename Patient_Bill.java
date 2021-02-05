

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
 * Servlet implementation class Patient_Bill
 */
@WebServlet("/Patient_Bill")
public class Patient_Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_Bill() {
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
		int phone=Integer.parseInt(request.getParameter("phone"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("select* from bill");
			while(rs.next())
			{
				String nam=rs.getString(1);
				String address=rs.getString(2);
				int phon=rs.getInt(3);
				String email=rs.getString(4);
				int age=rs.getInt(5);
				String consultant=rs.getString(6);
				String ad=rs.getString(7);
				String dd=rs.getString(8);
				String particular=rs.getString(9);
				int quantity=rs.getInt(10);
				int rate=rs.getInt(11);
				int amount=rs.getInt(12);
				if(nam.equals(name) && phon==phone)
				{
					out.print("<table>" +
							"<tr>" +
							"<th>Name</th>" +
							"<th>Address</th>" +
							"<th>Phone</th>" +
							"<th>Email</th>" +
							"<th>Age</th>" +
							"<th>Consultant</th>" +
							"<th>Admission Date</th>" +
							"<th>Discharge Date</th>" +
							"</tr>" +
							"<tr>" +
							"<td>"+nam+"</td>"+
							"<td>"+address+"</td>"+
							"<td>"+phon+"</td>" +
							"<td>"+email+"</td>"+
							"<td>"+age+"</td>"+
							"<td>"+consultant+"<td>"+
							"<td>"+ad+"</td>"+
							"<td>"+dd+"</td>"+
							"</tr>"+
							"</table>");
					out.print("--------------------------------------------------------------------------------------------");
					out.print("<table>" +
							"<tr>" +
							"<th>Particular</th>" +
							"<th>Quantity</th>" +
							"<th>Rate</th>" +
							"<th>Amount</th>" +
							"</tr>" +
							"<tr>" +
							"<td>"+particular+"</td>"+
							"<td>"+quantity+"</td>"+
							"<td>"+rate+"</td>"+
							"<td>"+amount+"</td>"+
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
