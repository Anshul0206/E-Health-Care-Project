

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
 * Servlet implementation class Diagonist_Report
 */
@WebServlet("/Diagonist_Report")
public class Diagonist_Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Diagonist_Report() {
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
		String p_problem=request.getParameter("p_problem");
		String p_status=request.getParameter("p_status");
		String date=request.getParameter("date");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_data?verifyServerCertificate=false&useSSL=false","root","anshul@2697");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into patient_report values(?,?,?,?)");
			ps.setString(1,p_name);
			ps.setString(2,p_problem);
			ps.setString(3,p_status);
			ps.setString(4,date);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.print("submitted successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Diagonist_Report.html");
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
