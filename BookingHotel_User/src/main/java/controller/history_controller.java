package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.reservation_bean;
import bean.user_bean;
import bo.reservation_bo;

/**
 * Servlet implementation class history_controller
 */
@WebServlet("/history_controller")
public class history_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public history_controller() {
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
			HttpSession session = request.getSession();
			user_bean user = (user_bean) session.getAttribute("dn");
			reservation_bo rbo = new reservation_bo();
			ArrayList<reservation_bean> ds = new ArrayList<reservation_bean>();
			
			if (user != null) {
				ds = rbo.getReservationById(user.getUser_id());

				request.setAttribute("ds", ds);
				RequestDispatcher rd = request.getRequestDispatcher("history_page.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("sign_in_controller");
			}

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
