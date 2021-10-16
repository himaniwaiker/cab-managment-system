package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminLoginDAO;
import dao.CustomerLoginDAO;
import dto.AdminLoginDTO;
import dto.CustomerLoginDTO;

/**
 * Servlet implementation class Student
 */
@WebServlet("/adminservlet")
public class adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public adminservlet() {
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("POST");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("AdminLogin")) {
			System.out.println("LOGIN");
			adminlogin(request, response);
		} else if (task.equalsIgnoreCase("STUDENT")) {
			System.out.println("STUDENT");
			StudentRegistration(request, response);
		}
    }

    private void adminlogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			AdminLoginDTO adminloginDTO = AdminLoginDAO.selectUseradminloginByALL(username, password);
			PrintWriter pw = response.getWriter();
			if (adminloginDTO != null) {
				System.out.println("Admin found  " + adminloginDTO.getId());
				request.setAttribute("LoginDTO", adminloginDTO);
				RequestDispatcher rd = request.getRequestDispatcher("registeredUsers.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("Admin not found.");

				pw.print(
						"<html><body onload='myFunction()'><script>function myFunction() {alert('User not found.');}</script></body></html>");

				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	protected void StudentRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		}
}

