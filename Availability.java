package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DBUtil;
import dto.AddDriverDTO;
import dao.AddDriverDAO;

@WebServlet("/availability")
public class Availability extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Availability() {

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("availability")) {
			System.out.println("Registered users");
			registeredUsers(request, response);
		} else if (task.equalsIgnoreCase("totalcomplaint")) {
			System.out.println("Total complaints ");
			totalcomplaint(request, response);
		}
		 else if (task.equalsIgnoreCase("feedback")) {
			System.out.println("find By Id ");
			feedback(request, response);
		}
	}
	private void registeredUsers(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<AddDriverDTO> registerDTOList = AddDriverDAO.selectComplaintByALL();
			request.setAttribute("registerDTOList", registerDTOList);

			RequestDispatcher rd = request.getRequestDispatcher("availability.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	private void totalcomplaint(HttpServletRequest request, HttpServletResponse response) {

		

	}
	private void feedback(HttpServletRequest request, HttpServletResponse response) {
}
}





