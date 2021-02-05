

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Patient_Registration
 */
@WebServlet("/Patient_Registration")
public class Patient_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_Registration() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String fname=request.getParameter("fname");
		int age=Integer.parseInt(request.getParameter("age"));
		String address=request.getParameter("address");
		String problem=request.getParameter("problem");
		String role=request.getParameter("role");
		String status=request.getParameter("status");
		String vdate=request.getParameter("vdate");
		String vdname=request.getParameter("vdname");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into Patient values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,pass);
			ps.setString(4,fname);
			ps.setInt(5,age);
			ps.setString(6,address);
			ps.setString(7,problem);
			ps.setString(8,role);
			ps.setString(9,status);
			ps.setString(10,vdate);
			ps.setString(11,vdname);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("Registered Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Patient_Registration.html");
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
