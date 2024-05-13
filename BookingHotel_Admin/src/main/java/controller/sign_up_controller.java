package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.account_bo;
import bo.user_bo;

/**
 * Servlet implementation class sign_up_controller
 */
@WebServlet("/sign_up_controller")
public class sign_up_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sign_up_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			user_bo userbo = new user_bo();
			account_bo accountbo = new account_bo();

			String name = request.getParameter("txtname");
			String email = request.getParameter("txtemail");
			String phone_number = request.getParameter("txtphone");
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String pass_confirm = request.getParameter("txtconfirm");
			String dob = request.getParameter("txtdob");

			if (name != null && email != null && phone_number != null && un != null && pass != null
					&& pass_confirm != null && dob != null) {
				if (!pass.equals(pass_confirm)) {
					request.setAttribute("wpass", "Wrong Password and Password Confirm");
					
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					request.setAttribute("phone_number", phone_number);
					request.setAttribute("un", un);
					request.setAttribute("dob", dob);
					
				} else {
					int addUser = userbo.addUser(name, dateFormat.parse(dob), phone_number, email);

					int user_id = userbo.getUserID();

					int addAccount = accountbo.addAccount(un, pass, user_id);
					
					response.sendRedirect("sign_in_controller");
					return;
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("sign_up_page.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
