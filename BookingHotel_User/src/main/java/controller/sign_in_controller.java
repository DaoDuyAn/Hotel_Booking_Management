package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.account_bean;
import bean.user_bean;
import bo.account_bo;
import bo.user_bo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class sign_in_controller
 */
@WebServlet("/sign_in_controller")
public class sign_in_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sign_in_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// an - 123
		// binh - 234
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// lấy về un, pass
			// Kiểm tra đăng nhập
			// tạo ra một session tên là dn, gán un vào session
			// Qua về trang menu
			// Ngược lại: Hiển thị thông báo
			HttpSession session = request.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);

			account_bo accountbo = new account_bo();
			user_bo userbo = new user_bo();

			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			//System.out.println(un + " " + pass);
			String txtcapcha = request.getParameter("txtcapcha");

			if (txtcapcha != null) {
				if (!captcha.isCorrect(txtcapcha)) {
					request.setAttribute("wpass", "Incorrect Captcha, please try again");
					request.setAttribute("showCapcha", "OK");
					RequestDispatcher rd = request.getRequestDispatcher("sign_in_page.jsp");
					rd.forward(request, response);
					return;
				}

			}
			if (un != null && pass != null) {

				int user_id = accountbo.checkLogin(un, pass, (int) 1);
				if (user_id != 0) {
					user_bean user = userbo.getUser(user_id);

					session.setAttribute("dn", user);
					session.setAttribute(un, (int) 0);

					response.sendRedirect("home_controller");
					return;
				} else {
					account_bean accountbean = accountbo.getAccount(un, (int) 1);

					if (accountbean != null) {
						int dnSai = 0;
						if (session.getAttribute(un) == null) {
							session.setAttribute(un, dnSai);
						}

						dnSai = (int) session.getAttribute(un) + 1;
						session.setAttribute(un, dnSai);

						if (dnSai >= 3) {

							request.setAttribute("showCapcha", "OK");
							request.setAttribute("wpass", "Wrong Password");
						} else {
							request.setAttribute("wpass", "Wrong Password");
						}

					} else {
						request.setAttribute("wpass", "Username does not exist.");
					}

					request.setAttribute("un", un);
					request.setAttribute("pass", pass);
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("sign_in_page.jsp");
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
