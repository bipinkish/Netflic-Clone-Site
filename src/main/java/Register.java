import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;


@WebServlet("/Register")

public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		


		String n = request.getParameter("userName");
		String e = request.getParameter("userEmail");
		String p = request.getParameter("userPass");		
		String t = request.getParameter("tel");
		String c = request.getParameter("userCountry");

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root",
					"TonyStark3000");

			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			
			

			ps.setString(1, n);
			ps.setString(2, e);
			ps.setString(3, p);
			ps.setString(4, t);
			ps.setString(5, c);
			

			int i = ps.executeUpdate();
			
			if (i > 0) {
				RequestDispatcher rs = request.getRequestDispatcher("/Login.html");
				rs.include(request, response);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		out.close();
	}

}