package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.room_type_bean;
import bo.room_type_bo;

/**
 * Servlet implementation class room_type_management_controller
 */
@WebServlet("/room_type_management_controller")
public class room_type_management_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public room_type_management_controller() {
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
			room_type_bo rtbo = new room_type_bo();

			String rtid = request.getParameter("txtrtid");
			String rtn = request.getParameter("txtrtn");
			String rtsize = request.getParameter("txtsize");
			String rtcapacity = request.getParameter("txtcapacity");
			String rtprice = request.getParameter("txtprice");
			String rtdesc = request.getParameter("txtdesc");

			// Action button
			String btnadd = request.getParameter("btnadd");
			String btnupdate = request.getParameter("btnupdate");
			String btndelete = request.getParameter("btndelete");
			String btnselect = request.getParameter("btnselect");
			String btndeletetbl = request.getParameter("btndeletetbl");

			if (btnselect != null) {
				room_type_bean rtbean = rtbo.getRoomTypeById(Integer.parseInt(btnselect));
				
				request.setAttribute("rtid", rtbean.getRoom_type_id());
				request.setAttribute("rtn", rtbean.getRoom_type_name());
				request.setAttribute("size", rtbean.getSize());
				request.setAttribute("capacity", rtbean.getCapacity());
				request.setAttribute("price", rtbean.getPrice());
				request.setAttribute("desc", rtbean.getDescription());
			}

			if (btndeletetbl != null) {
				if (rtid != null) {
					int deleteRoomType = rtbo.deleteRoomType(Integer.parseInt(rtid));
					request.setAttribute("success", "Successful deletion!");
				}
			}

			if (btnadd != null) {
				if (rtn != null && rtsize != null && rtcapacity != null && rtprice != null && rtdesc != null) {
					int addRoomType = rtbo.addRoomType(rtn, Integer.parseInt(rtsize), Integer.parseInt(rtcapacity),
							Long.parseLong(rtprice), rtdesc);
					request.setAttribute("success", "Successful addition!");
				}
			}

			if (btnupdate != null) {
				if (rtid != null && rtn != null && rtsize != null && rtcapacity != null && rtprice != null
						&& rtdesc != null) {
					int updateRoomType = rtbo.updateRoomType(Integer.parseInt(rtid), rtn, Integer.parseInt(rtsize),
							Integer.parseInt(rtcapacity), Long.parseLong(rtprice), rtdesc);
					request.setAttribute("success", "Successful edition!");
				}
			}

			if (btndelete != null) {
				if (rtid != null) {
					int deleteRoomType = rtbo.deleteRoomType(Integer.parseInt(rtid));
					request.setAttribute("success", "Successful deletion!");
				}
			}

			ArrayList<room_type_bean> ds = rtbo.getAllRoomType();
			request.setAttribute("ds", ds);

			RequestDispatcher rd = request.getRequestDispatcher("room_type_management_page.jsp");
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
