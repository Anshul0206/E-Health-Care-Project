

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
 * Servlet implementation class Create_Admin
 */
@WebServlet("/Create_Admin")
public class Create_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_Admin() {
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
	 	String email=request.getParameter("email");
	 	String pass=request.getParameter("pass");
	 	String address=request.getParameter("address");
	 	String dob=request.getParameter("dob");
	 	String sex=request.getParameter("sex");
	 	String role=request.getParameter("role");
	 	try{
	  		Class.forName("com.mysql.jdbc.Driver");
	  		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data","root","anshul@2697");  
	  		PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into admin values(?,?,?,?,?,?,?)");
	  		ps.setString(1,name);
	  		ps.setString(2,email);
	  		ps.setString(3,pass);
	  		ps.setString(4,address);
	  		ps.setString(5,dob);
	  		ps.setString(6,sex);
	  		ps.setString(7,role);
	  		int i=ps.executeUpdate();  
			if(i>0)  
				out.println("Registered Successfull"); 
				RequestDispatcher rd=request.getRequestDispatcher("Create_Admin.html");
				rd.forward(request, response);
	  		
	  	}catch(Exception e)
	  	{
	  	System.out.println(e);
	  	}
	}

}
