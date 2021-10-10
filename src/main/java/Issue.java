import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/Issue")

public class Issue extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		


		String e = request.getParameter("userEmail");
		String m = request.getParameter("issue");


		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root",
					"TonyStark3000");

			
			PreparedStatement ps = con.prepareStatement("insert into complaint values(?,?)");
			
			

			ps.setString(1, e);
			ps.setString(2, m);


			int i = ps.executeUpdate();
			if (i > 0) {
				RequestDispatcher rs = request.getRequestDispatcher("/Success.html");
				rs.include(request, response);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		out.close();
	}

}