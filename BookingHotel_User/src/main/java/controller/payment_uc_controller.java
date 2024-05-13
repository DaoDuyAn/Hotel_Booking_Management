package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.reserved_room_bean;
import bean.room_bean;
import bean.user_bean;
import bo.occupied_room_bo;
import bo.reservation_bo;
import bo.reserved_room_bo;
import bo.room_bo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class payment_uc_controller
 */
@WebServlet("/payment_uc_controller")
public class payment_uc_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public payment_uc_controller() {
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

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			occupied_room_bo ocbo = new occupied_room_bo();
			reserved_room_bo rdbo = new reserved_room_bo();
			room_bo roombo = new room_bo();
			reservation_bo rvbo = new reservation_bo();

			String action = request.getParameter("action");
			request.setAttribute("action", action);

			String btnaccept = request.getParameter("btnaccept");
			if (btnaccept != null) {
				String txtcapcha = request.getParameter("txtcapcha");

				if (txtcapcha != null) {
					if (!captcha.isCorrect(txtcapcha)) {
						request.setAttribute("wpass", "Incorrect Captcha, please try again");
						request.setAttribute("showCapcha", "OK");
						RequestDispatcher rd = request.getRequestDispatcher("payment_uc_page.jsp");
						rd.forward(request, response);
						return;
					} else {
						user_bean user = (user_bean) session.getAttribute("dn");
						reserved_room_bean rNewbean = (reserved_room_bean) session.getAttribute("rbean");
						reserved_room_bean rOldbean = rdbo.getReservedRoomByRid(rNewbean.getReserved_room_id());
						
						// Update reservation tbl
						int updateRv = rvbo.updateReservation(rNewbean.getReservation_id(), "Unpaid");
						
						if (action.equals("update")) {
							// Update reserved_room tbl
							int updateRd = rdbo.updateReservedRoom(rNewbean.getReserved_room_id(),
									rNewbean.getReservation_id(), rNewbean.getRoom_type_id(),
									rNewbean.getNum_of_rooms(), rNewbean.getGuest_count(), rNewbean.getPrice(),
									rNewbean.getCheck_in(), rNewbean.getCheck_out(), rNewbean.getPayment_status(),
									rNewbean.getStatus());

							// Delete all room in occupied_room belongs to reserved_room_id
							int deleteOR = ocbo.deleteOccupiedRoom(rNewbean.getReservation_id(),
									rOldbean.getRoom_type_id());

							// Add to occupied_room tbl
							ArrayList<room_bean> lst_room = roombo.getAllRoomAvailUpdate(rNewbean.getNum_of_rooms(),
									sdf.format(rNewbean.getCheck_in()), sdf.format(rNewbean.getCheck_out()),
									rNewbean.getRoom_type_id(), rNewbean.getReserved_room_id());

							for (room_bean room : lst_room) {
								int addOccupiedRoom = ocbo.addOccupiedRoom(rNewbean.getReservation_id(),
										room.getRoom_id(), sdf.format(rNewbean.getCheck_in()),
										sdf.format(rNewbean.getCheck_out()));

								//int occupiedId = ocbo.getMaxOccupiedRooomId();
							}

						}
						
						if (action.equals("cancel")) {
							// Update reserved_room tbl
							int updateRd = rdbo.updateReservedRoom(rNewbean.getReserved_room_id(),
									rNewbean.getReservation_id(), rNewbean.getRoom_type_id(),
									rNewbean.getNum_of_rooms(), rNewbean.getGuest_count(), rNewbean.getPrice(),
									rNewbean.getCheck_in(), rNewbean.getCheck_out(), rNewbean.getPayment_status(),
									"Cancellation pending");
							// Delete all room in occupied_room belongs to reserved_room_id
							int deleteOR = ocbo.deleteOccupiedRoom(rNewbean.getReservation_id(),
									rOldbean.getRoom_type_id());
							
						}

						session.removeAttribute("rbean");
						response.sendRedirect("history_controller");
						return;
					}

				}
			}

			if (action.equals("update")) {

				reserved_room_bean rNewbean = (reserved_room_bean) session.getAttribute("rbean");
				reserved_room_bean rOldbean = rdbo.getReservedRoomByRid(rNewbean.getReserved_room_id());

				double oldPrice = rdbo.getPrepaymentItem(rOldbean);
				double newPrice = rdbo.getPrepaymentItem(rNewbean);

				double diffPrice = newPrice - oldPrice;
				request.setAttribute("diffPrice", diffPrice);

			}

			if (action.equals("cancel")) {
				reserved_room_bean rbean = (reserved_room_bean) session.getAttribute("rbean");
				
				double refund = (rbean.getPrice() * rbean.getNum_of_rooms() * 10) / 100 ;
				request.setAttribute("diffPrice", refund);
			}

			request.setAttribute("showCapcha", "OK");

			RequestDispatcher rd = request.getRequestDispatcher("payment_uc_page.jsp");
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
