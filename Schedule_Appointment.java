import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Shedule_Appointment
 */
@WebServlet("/Shedule_Appointment")
public class Shedule_Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shedule_Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		String p_name=request.getParameter("p_name");
		String p_problem=request.getParameter("p_problem");
		String p_status=request.getParameter("p_status");
		String d_name=request.getParameter("d_name");
		String d_specification=request.getParameter("d_specification");
		String d_role=request.getParameter("d_role");
		String a_date=request.getParameter("a_date");
		String cs=request.getParameter("cs");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			PreparedStatement ps=con.prepareStatement("insert into Shedule_Appointment values(?,?,?,?,?,?,?,?)");
			ps.setString(1,p_name);
			ps.setString(2,p_problem);
			ps.setString(3,p_status);
			ps.setString(4,d_name);
			ps.setString(5,d_specification);
			ps.setString(6,d_role);
			ps.setString(7,a_date);
			ps.setString(8,cs);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("Successfully Scheduled");
				RequestDispatcher rd=request.getRequestDispatcher("Shedule_Appointment.html");
				rd.forward(request,response);
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
