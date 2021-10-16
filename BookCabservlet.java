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

import dao.AddDriverDAO;
import dao.CustomerRegistrationDAO;
import dto.AddDriverDTO;
import dto.CustomerRegistrationDTO;

/**
 * Servlet implementation class ComplaintServlet
 */
@WebServlet("/complaints")
public class BookCabservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddDriverDTO complaintDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCabservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("findAll")) {
			System.out.println("Find All");

		} else if (task.equalsIgnoreCase("findById")) {
			System.out.println("find By Id ");
			findById(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("closeComplaint")) {
			System.out.println("Close Complaint");
			closeById(request, response);
		} 
		
	}

	private void findById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		System.out.println("Find Complaint by Id : "  + id);
		try {
			AddDriverDTO complaintRegisterDTO = AddDriverDAO.selectComplaintRegisterById(Integer.parseInt(id));
			request.setAttribute("complaintRegisterDTO", complaintRegisterDTO);
			
			RequestDispatcher rd = request.getRequestDispatcher("Booked.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private void closeById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		System.out.println("Close complaint find Complaint by Id  : "  + id);
		try {
			int count = AddDriverDAO.updatecomplaintInfo(Integer.parseInt(id));
		System.out.println("Count : " + count);
			PrintWriter pw = response.getWriter();
			pw.print(
					"<html><body onload='myFunction()'><script>function myFunction() {alert('Booking Confirm Succesfully');}</script></body></html>");		
			RequestDispatcher rd = request.getRequestDispatcher("homes");
			rd.include(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
