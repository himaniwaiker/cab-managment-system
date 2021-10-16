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
import dto.CustomerLoginDTO;
import dao.AddDriverDAO;
import dao.CustomerLoginDAO;
import dao.CustomerRegistrationDAO;
import dto.CustomerRegistrationDTO;

@WebServlet("/users")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Userservlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("findAll")) {
			System.out.println("Find All");
			findAll(request, response);
		} else if (task.equalsIgnoreCase("findById")) {
			System.out.println("find By Id ");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("POST");
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("login")) {
			System.out.println("LOGIN");
			login(request, response);
		} else if (task.equalsIgnoreCase("Customer")) {
			System.out.println("Customer");
			StudentRegistration(request, response);
		}
		if (task.equalsIgnoreCase("Customer")) {
			System.out.println("Customer");
			StudentRegistration(request, response);
		} else if (task.equalsIgnoreCase("complaint")) {
			System.out.println("Complaint Register");
			complaint(request, response);
			
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			CustomerLoginDTO userloginDTO = CustomerLoginDAO.selectUserloginByALL(email, password);
			PrintWriter pw = response.getWriter();
			if (userloginDTO != null) {
				System.out.println("User found with id : " + userloginDTO.getId());
				request.setAttribute("LoginDTO", userloginDTO);
				RequestDispatcher rd = request.getRequestDispatcher("availability.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("User not found.");

				pw.print(
						"<html><body onload='myFunction()'><script>function myFunction() {alert('User not found.');}</script></body></html>");

				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void StudentRegistration(HttpServletRequest request, HttpServletResponse response) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String housenumber = request.getParameter("housenumber");
		String streetnumber = request.getParameter("streetnumber");
		String pincode = request.getParameter("pincode");
		String mobilenumber = request.getParameter("mobilenumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		CustomerRegistrationDTO registrationDTO = new CustomerRegistrationDTO();
		registrationDTO.setFirstname(firstname);
		registrationDTO.setLastname(lastname);
		registrationDTO.setGender(gender);
		registrationDTO.setHousenumber(housenumber);
		registrationDTO.setStreetnumber(streetnumber);

		registrationDTO.setPincode(pincode);
		registrationDTO.setMobilenumber(mobilenumber);
		registrationDTO.setEmail(email);
		registrationDTO.setPassword(password);

		try {
			PrintWriter pw = response.getWriter();

			int count = CustomerRegistrationDAO.insertRegistrationInfo(registrationDTO);
			if (count != 0) {
				System.out.println("Data  Save Successfully");
				pw.print(
						"<html><body onload='myFunction()'><script>function myFunction() {alert('Data Save Succesfully');}</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			} else {
				System.out.println("Failed to save data");
				pw.print(
						"<html><body onload='myFunction()'><script>function myFunction() {alert('Data Save Succesfully');}</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("Customer.jsp");
				rd.include(request, response);
			}
		} catch (Exception ex) {
			try {
				PrintWriter pw = response.getWriter();

				String message = ex.getMessage();
				System.out.println(message);
				pw.print("<html><body onload='myFunction()'><script>function myFunction() {alert(' " + message
						+ "');}</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");

				rd.include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}
	
	private void complaint(HttpServletRequest request, HttpServletResponse response) {
		String drivername = request.getParameter("drivername");
		String gender = request.getParameter("gender");
		String mobilenumber = request.getParameter("mobilenumber");
		String vehiclename = request.getParameter("vehiclename");
		String costperkm = request.getParameter("costperkm");

		AddDriverDTO complaintDTO = new AddDriverDTO();
		complaintDTO.setDrivername(drivername);
		complaintDTO.setGender(gender);
		complaintDTO.setMobilenumber(mobilenumber);
		complaintDTO.setVehiclename(vehiclename);
		complaintDTO.setCostperkm(costperkm);

		try {
			PrintWriter pw = response.getWriter();
			int count = AddDriverDAO.insertcomplaintRegister(complaintDTO);
			if (count != 0) {

				AddDriverDTO complaintRegisterDTO = AddDriverDAO.selectLastComplaintRegisterId();
				String message = "driver Added  with id : " + complaintRegisterDTO.getId();
				System.out.println(message);
				pw.print("<html><body onload='myFunction()'><script>function myFunction() {alert(' " + message
						+ "');}</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("complaint.jsp");
				rd.include(request, response);
			} else {
				System.out.println("Failed to Register Complaint");
				pw.print(
						"<html><body onload='myFunction()'><script>function myFunction() {alert('Failed to Register Complaint');}</script></body></html>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<CustomerRegistrationDTO> registerDTOList = CustomerRegistrationDAO.selectRegistrationByALL();
			request.setAttribute("registerDTOList", registerDTOList);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	private void registeredUsers(HttpServletRequest request, HttpServletResponse response) {
	}
}
