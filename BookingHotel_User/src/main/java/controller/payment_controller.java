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

import bean.booking_bean;
import bean.room_bean;
import bean.user_bean;
import bo.booking_bo;
import bo.occupied_room_bo;
import bo.reservation_bo;
import bo.reserved_room_bo;
import bo.room_bo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class payment_controller
 */
@WebServlet("/payment_controller")
public class payment_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public payment_controller() {
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
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);

			booking_bo bk = (booking_bo) session.getAttribute("bk");

			String btnAcceptValue = request.getParameter("btnaccept");

			if (btnAcceptValue != null) {

				String txtcapcha = request.getParameter("txtcapcha");

				if (txtcapcha != null) {
					if (!captcha.isCorrect(txtcapcha)) {
						request.setAttribute("wpass", "Incorrect Captcha, please try again");
						request.setAttribute("showCapcha", "OK");
						RequestDispatcher rd = request.getRequestDispatcher("payment_page.jsp");
						rd.forward(request, response);
						return;
					} else {
						user_bean user = (user_bean) session.getAttribute("dn");

						reservation_bo rbo = new reservation_bo();
						reserved_room_bo rdbo = new reserved_room_bo();
						room_bo roombo = new room_bo();
						occupied_room_bo ocbo = new occupied_room_bo();
						ArrayList<room_bean> lst_room = new ArrayList<room_bean>();
						
						// Create one reservation
						int addReservation = rbo.addReservation(user.getUser_id(), "Unpaid");
						int reservationId = rbo.getMaxReservationId();

						// Add to reserved_room tbl
						for (booking_bean item : bk.ds) {
							int addReservedRoom = rdbo.addReservedRoom(reservationId, item.getRoom_type_id(),
									item.getNum_of_rooms(), item.getGuest_count(), item.getPrice(), item.getCheckin(),
									item.getCheckout(), item.getPayment_status());

							// Add to occupied_room tbl
							lst_room = roombo.getAllRoomAvail(item.getNum_of_rooms(), item.getCheckin(),
									item.getCheckout(), item.getRoom_type_id());

							for (room_bean room : lst_room) {
								int addOccupiedRoom = ocbo.addOccupiedRoom(reservationId, room.getRoom_id(),
										item.getCheckin(), item.getCheckout());

								// int occupiedId = ocbo.getMaxOccupiedRooomId();
							}
						}

						session.removeAttribute("bk");

						response.sendRedirect("history_controller");
						return;
					}
				}

			}

			if (session.getAttribute("bk") != null) {
				request.setAttribute("prepayment", bk.getPrepayment());
			}
			request.setAttribute("showCapcha", "OK");
			RequestDispatcher rd = request.getRequestDispatcher("payment_page.jsp");
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
