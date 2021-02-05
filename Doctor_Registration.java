

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Doctor_Registration
 */
@WebServlet("/Doctor_Registration")
public class Doctor_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctor_Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				response.setContentType("html/text");
				PrintWriter out=response.getWriter();
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String pass=request.getParameter("pass");
				String address=request.getParameter("address");
				int age=Integer.parseInt(request.getParameter("age"));
				String specification=request.getParameter("specification");
				String qualification=request.getParameter("qualification");
				int percentage=Integer.parseInt(request.getParameter("percentage"));
				String role=request.getParameter("role");
				String status=request.getParameter("status");
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into Doctor values(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1,name);
					ps.setString(2,email);
					ps.setString(3,pass);
					ps.setString(4,address);
					ps.setInt(5,age);
					ps.setString(6,specification);
					ps.setString(7,qualification);
					ps.setInt(8,percentage);
					ps.setString(9,role);
					ps.setString(10,status);
					int i=ps.executeUpdate();
					if(i>0)
					{
						out.println("Registered Successfully");
						RequestDispatcher rd=request.getRequestDispatcher("Doctor_Registration.html");
						rd.forward(request,response);
					}
					
				}catch(Exception E)
				{
					 E.printStackTrace();
				}
	}

}
