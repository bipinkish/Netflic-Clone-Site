import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/Upload")

public class Upload extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		MultipartRequest m = new MultipartRequest(request, "F:/new");
		RequestDispatcher rs = request.getRequestDispatcher("/Success.html");
		rs.include(request, response);
	}
}