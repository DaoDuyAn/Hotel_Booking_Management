package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.booking_bean;
import bean.reserved_room_bean;
import bean.room_type_bean;
import bo.booking_bo;
import bo.reserved_room_bo;
import bo.room_bo;
import bo.room_type_bo;

/**
 * Servlet implementation class update_cancel_controller
 */
@WebServlet("/update_cancel_controller")
public class update_cancel_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public update_cancel_controller() {
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			reserved_room_bo rdbo = new reserved_room_bo();
			room_bo rbo = new room_bo();
			room_type_bo rtbo = new room_type_bo();

			ArrayList<room_type_bean> lst_roomType = rtbo.getAllRoomType();
			request.setAttribute("lst_rt", lst_roomType);

			reserved_room_bean rbean = (reserved_room_bean) session.getAttribute("rbean");
			

			String roomTypeName = request.getParameter("rtn");
			String checkin = request.getParameter("ci");
			String checkout = request.getParameter("co");
			String numOfRooms = request.getParameter("nor");
			String guestCount = request.getParameter("gc");
			String payment = request.getParameter("payment");

			String action = request.getParameter("action");
			request.setAttribute("action", action);

			if (action.equals("update")) {
				request.setAttribute("showUpdate", "OK");
			}

			if (action.equals("cancel")) {
				request.setAttribute("showCancel", "OK");
			}
			
			//  Button action
			String btncheck = request.getParameter("btncheck");
			String btnupdate = request.getParameter("btnupdate");
			String btncancel = request.getParameter("btncancel");
			String btnconfirm = request.getParameter("btnconfirm");
			String btnback = request.getParameter("btnback");
			
			if (btnback != null) {
				int rid = rbean.getReservation_id(); 
			    
			    try {
			        String encodedRid = URLEncoder.encode(String.valueOf(rid), "UTF-8");

			        response.sendRedirect("history_detail_controller?rid=" + encodedRid);
			        return;
			    } catch (UnsupportedEncodingException e) {
			        e.printStackTrace();
			    }
			}
			
			// Button confirm
			if (btnconfirm != null) {
				if (action.equals("update")) {
					response.sendRedirect("payment_uc_controller?action=update");
					return;
				} else {
					response.sendRedirect("payment_uc_controller?action=cancel");
					return;
				}
			}
			
			if (btncancel != null) {
				response.sendRedirect("payment_uc_controller?action=cancel");
				return;
			}
			
			// Button update
			if (btnupdate != null) {
				room_type_bean rtbean = rtbo.getRoomTypeByName(roomTypeName);
				System.out.println(roomTypeName + rtbean.getPrice() + numOfRooms);
				
				reserved_room_bean rNewbean = new reserved_room_bean();
				 
				rNewbean.setReservation_id(rbean.getReservation_id());
				rNewbean.setReserved_room_id(rbean.getReserved_room_id());
				rNewbean.setGuest_count(Integer.parseInt(guestCount));
				rNewbean.setNum_of_rooms(Integer.parseInt(numOfRooms));
				rNewbean.setPayment_status(Integer.parseInt(payment));
				rNewbean.setRoom_type_name(roomTypeName);
				rNewbean.setRoom_type_id(rtbean.getRoom_type_id());
				rNewbean.setPrice(rtbean.getPrice());
				rNewbean.setCheck_in(sdf.parse(checkin));
				rNewbean.setCheck_out(sdf.parse(checkout));
				rNewbean.setTotal(rdbo.getTotal(sdf.parse(checkin), sdf.parse(checkout), rtbean.getPrice(), Integer.parseInt(numOfRooms)));
				rNewbean.setStatus("Pending approval");
				
				session.setAttribute("rbean", rNewbean);
				
				// ---
				request.setAttribute("rtn", roomTypeName);
				request.setAttribute("ci", checkin);
				request.setAttribute("co", checkout);
				request.setAttribute("nor", numOfRooms);
				request.setAttribute("gc", guestCount);
				request.setAttribute("payment", payment);
				request.setAttribute("rid", rbean.getReserved_room_id());

				RequestDispatcher rd = request.getRequestDispatcher("update_cancel_page.jsp");
				rd.forward(request, response);
				return;
			}
			
			// Button check
			if (btncheck != null) {
				reserved_room_bean rb = (reserved_room_bean) session.getAttribute("rbean");
				
				boolean check = true;
				String msg = "";
				int countRoomAvail = 0;
				int capacity = 0;

				countRoomAvail = rbo.getCountRoomAvailUpdate(checkin, checkout, rb.getRoom_type_id(),
						rbean.getReserved_room_id());
				System.out.println("countRoomAvail: " + countRoomAvail);
			
				if (countRoomAvail < Integer.parseInt(numOfRooms)) {
					check = false;
					msg += "* Doesn't have enough rooms. <br/>";
				} else {
					capacity = rtbo.getCapacity(rb.getRoom_type_id());
					if (capacity * Integer.parseInt(numOfRooms) < Integer.parseInt(guestCount)) {
						check = false;
						msg += "* Exceeds the allowed number of people. <br/>";
					}
				}

				countRoomAvail = 0;
				capacity = 0;

				if (check) {
					request.setAttribute("success", "Reservation details are acceptable.");
					request.setAttribute("showBtnConfirm", "OK");
				} else {
					request.setAttribute("danger", msg);
				}

				request.setAttribute("rtn", roomTypeName);
				request.setAttribute("ci", checkin);
				request.setAttribute("co", checkout);
				request.setAttribute("nor", numOfRooms);
				request.setAttribute("gc", guestCount);
				request.setAttribute("payment", payment);
				request.setAttribute("rid", rbean.getReserved_room_id());

				RequestDispatcher rd = request.getRequestDispatcher("update_cancel_page.jsp");
				rd.forward(request, response);
				return;
			}
			
			session.setAttribute("rbean", rbean);

			request.setAttribute("rtn", rbean.getRoom_type_name());
			request.setAttribute("ci", rbean.getCheck_in());
			request.setAttribute("co", rbean.getCheck_out());
			request.setAttribute("nor", rbean.getNum_of_rooms());
			request.setAttribute("gc", rbean.getGuest_count());
			request.setAttribute("payment", rbean.getPayment_status());
			request.setAttribute("rid", rbean.getReserved_room_id());

			RequestDispatcher rd = request.getRequestDispatcher("update_cancel_page.jsp");
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
