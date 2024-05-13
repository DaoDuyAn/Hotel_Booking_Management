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
import javax.servlet.http.HttpSession;

import bean.booking_bean;
import bo.booking_bo;
import bo.room_bo;
import bo.room_type_bo;

/**
 * Servlet implementation class booking_controller
 */
@WebServlet("/booking_controller")
public class booking_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public booking_controller() {
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
			
			HttpSession session = request.getSession();
			
			room_bo rbo = new room_bo();
			room_type_bo rtbo = new room_type_bo();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			String rtid = request.getParameter("rtid");
			String rtn = request.getParameter("rtn");
			String rtp = request.getParameter("rtp");

			// Button action
			String btnconfirm = request.getParameter("btnconfirm");
			String btnback = request.getParameter("btnback");
			String btnupdate = request.getParameter("btnupdate");
			String btndelall = request.getParameter("btndelall");
			String btndel = request.getParameter("btndel");
			String[] ds = request.getParameterValues("c1"); // checkbox
			
			if (session.getAttribute("dn") == null) {
				response.sendRedirect("sign_in_controller");
				return;
			} 

			// Confirm
			if (btnconfirm != null) {
				response.sendRedirect("payment_controller");
				return;
			}

			// Back to Rooms page
			if (btnback != null) {
				response.sendRedirect("room_controller");
				return;
			}

			booking_bo bk = null;
			if (session.getAttribute("bk") != null) {
				bk = (booking_bo) session.getAttribute("bk");
			}

			// Add booking
			if (rtid != null && rtn != null && rtp != null) {
				// First booking
				if (session.getAttribute("bk") == null) {
					bk = new booking_bo();
					session.setAttribute("bk", bk);
				}

				bk = (booking_bo) session.getAttribute("bk");

				Date d = new Date();
				String formattedDate = sdf.format(d);

				bk.addBooking(Integer.parseInt(rtid), formattedDate, formattedDate, 1, 1, 10, rtn, Long.parseLong(rtp));
				session.setAttribute("bk", bk);
			}

			if (btndel != null) {
				bk = (booking_bo) session.getAttribute("bk");
				bk.deleteBooking(Integer.parseInt(btndel));
			}

			if (btndelall != null) {
				bk = (booking_bo) session.getAttribute("bk");
				bk.deleteAll();
			}

			if (ds != null) {
				bk = (booking_bo) session.getAttribute("bk");
				for (String id : ds) {
					bk.deleteBooking(Integer.parseInt(id));
				}
			}

			if (btnupdate != null) {
				String checkin = request.getParameter("ci-" + btnupdate);
				String checkout = request.getParameter("co-" + btnupdate);
				String numOfRooms = request.getParameter("nor-" + btnupdate);
				String guestCount = request.getParameter("gc-" + btnupdate);
				String payment = request.getParameter("payment-" + btnupdate);

				bk = (booking_bo) session.getAttribute("bk");
				bk.updateBooking(Integer.parseInt(btnupdate), checkin, checkout, Integer.parseInt(numOfRooms),
						Integer.parseInt(guestCount), Integer.parseInt(payment));
			}

			
			
			
			session.setAttribute("bk", bk);

			response.sendRedirect("booking_show_controller");
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
