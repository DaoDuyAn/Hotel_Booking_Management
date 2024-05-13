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

import bean.reserved_room_bean;
import bo.reserved_room_bo;
import bo.room_type_bo;

/**
 * Servlet implementation class history_detail_controller
 */
@WebServlet("/history_detail_controller")
public class history_detail_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history_detail_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			
			reserved_room_bo rdbo = new reserved_room_bo();
			room_type_bo rtbo = new room_type_bo();
			
			String rid = request.getParameter("rid");
			
			String btnupdate = request.getParameter("btnupdate");
			String btncancel = request.getParameter("btncancel");
			String btnback = request.getParameter("btnback");

			ArrayList<reserved_room_bean> ds = new ArrayList<reserved_room_bean>();
			
			if (rid != null) {
				int reservationId = Integer.parseInt(rid);
				ds = rdbo.getReservedRoomById(reservationId);
				
				request.setAttribute("lst_rd", ds);
				request.setAttribute("totalPrice", rdbo.getToTalPrice(ds));
			
			}
			
			if (btnback != null) {
				response.sendRedirect("history_controller");
				return;
			}
			
			if(btnupdate != null) {
				reserved_room_bean rbean = rdbo.getReservedRoomByRid(Integer.parseInt(btnupdate));
				session.setAttribute("rbean", rbean);
				response.sendRedirect("update_cancel_controller?action=update");

				return;
			}
			
			if(btncancel != null) {
				reserved_room_bean rbean = rdbo.getReservedRoomByRid(Integer.parseInt(btncancel));
				session.setAttribute("rbean", rbean);
				response.sendRedirect("update_cancel_controller?action=cancel");
	
				return;
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("history_detail_page.jsp");
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
