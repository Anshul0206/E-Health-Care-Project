

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
 * Servlet implementation class Generate_Bill
 */
@WebServlet("/Generate_Bill")
public class Generate_Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate_Bill() {
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
		String address=request.getParameter("address");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		String consultant=request.getParameter("consultant");
		String ad=request.getParameter("ad");
		String dd=request.getParameter("dd");
		String particular=request.getParameter("particular");
		int qty=Integer.parseInt(request.getParameter("qty"));
		int rate=Integer.parseInt(request.getParameter("rate"));
		int amount=qty*rate;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into bill values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setInt(3,phone);
			ps.setString(4,email);
			ps.setInt(5,age);
			ps.setString(6,consultant);
			ps.setString(7,ad);
			ps.setString(8,dd);
			ps.setString(9,particular);
			ps.setInt(10,qty);
			ps.setInt(11,rate);
			ps.setInt(12,amount);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.print("Successfully Generated");
				RequestDispatcher rd=request.getRequestDispatcher("Generate_Bill.html");
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
