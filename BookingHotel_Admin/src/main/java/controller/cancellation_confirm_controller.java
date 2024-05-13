package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.reserved_room_bean;
import bo.reservation_bo;
import bo.reserved_room_bo;

/**
 * Servlet implementation class cancellation_confirm_controller
 */
@WebServlet("/cancellation_confirm_controller")
public class cancellation_confirm_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancellation_confirm_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			reserved_room_bo rdbo = new reserved_room_bo();
			reservation_bo rvbo = new reservation_bo();
			
			String rdid = request.getParameter("rdid");
			String rvid = request.getParameter("rvid");

			if (rdid != null && rvid != null) {
				int updateRD = rdbo.updateStatusByRdId(Integer.parseInt(rdid), "Cancel");
				
				ArrayList<reserved_room_bean> ds = rdbo.getReservedRoomById(Integer.parseInt(rvid));
				if (rdbo.isEveryReservationFullyPaid(ds)) {
					int updateRV = rvbo.updatePaymentStatusById(Integer.parseInt(rvid), "Paid");
				}
				
				request.setAttribute("success", "Confirmation successful!");
			}
			
			ArrayList<reserved_room_bean> ds = rdbo.getReservedConfirm("Cancellation pending");
			request.setAttribute("ds", ds);

			RequestDispatcher rd = request.getRequestDispatcher("cancellation_confirm_page.jsp");
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
