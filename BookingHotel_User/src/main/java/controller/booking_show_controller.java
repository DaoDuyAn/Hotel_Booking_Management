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
import bean.room_type_bean;
import bo.booking_bo;
import bo.room_bo;
import bo.room_type_bo;

/**
 * Servlet implementation class booking_show_controller
 */
@WebServlet("/booking_show_controller")
public class booking_show_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking_show_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			booking_bo bk = (booking_bo) session.getAttribute("bk");

			room_bo rbo = new room_bo();
			room_type_bo rtbo = new room_type_bo();
			
			if (session.getAttribute("bk") != null) {
				request.setAttribute("dsbk", bk.ds);
				request.setAttribute("totalPrice", bk.getToTalPrice());
			}

			String btncheck = request.getParameter("btncheck");
			if (btncheck != null) {
				System.out.println(btncheck);
				boolean check = true;
				String msg = "";
				int countRoomAvail = 0;
				int capacity = 0;

				bk = (booking_bo) session.getAttribute("bk");
				for (booking_bean item : bk.ds) {
					countRoomAvail = rbo.getCountRoomAvail(item.getCheckin(), item.getCheckout(),
							item.getRoom_type_id());
					if (countRoomAvail < item.getNum_of_rooms()) {
						check = false;
						msg += "* ID-" + item.getBooking_id() + " doesn't have enough rooms. <br/>";
					} else {
						capacity = rtbo.getCapacity(item.getRoom_type_id());
						if (capacity * item.getNum_of_rooms() < item.getGuest_count()) {
							check = false;
							msg += "* ID-" + item.getBooking_id() + " exceeds the allowed number of people. <br/>";
						}
					}

					countRoomAvail = 0;
					capacity = 0;
				}
				
				if (check) {
					request.setAttribute("success", "Reservation details are acceptable.");
					request.setAttribute("showBtnConfirm", "OK");
				} else {
					request.setAttribute("danger", msg);
				}
			} 
			
			ArrayList<room_type_bean> lst_roomType_search = rtbo.getAllRoomType();
			request.setAttribute("lst_roomType_search", lst_roomType_search);

			RequestDispatcher rd = request.getRequestDispatcher("booking_page.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
