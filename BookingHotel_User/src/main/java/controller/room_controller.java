package controller;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.images_bean;
import bean.room_type_bean;
import bo.images_bo;
import bo.room_type_bo;

/**
 * Servlet implementation class room_controller
 */
@WebServlet("/room_controller")
public class room_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public room_controller() {
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
			request.setCharacterEncoding("utf-8"); // client gửi data lên server bằng utf-8
			response.setCharacterEncoding("utf-8");
			
			images_bo imgbo = new images_bo();
			room_type_bo roomtypebo = new room_type_bo();

			ArrayList<images_bean> lst_img = imgbo.getAllImages();
			ArrayList<room_type_bean> lst_roomType = roomtypebo.getAllRoomType();
			ArrayList<room_type_bean> lst_roomType_search = roomtypebo.getAllRoomType();
			
			String typeOfRoom = request.getParameter("typeOfRoom");
	        String numberOfPersons = request.getParameter("numberOfPersons");

	        if (typeOfRoom != null && numberOfPersons != null) {
	        	lst_roomType = roomtypebo.getRoomTypeByKey(Integer.parseInt(typeOfRoom), Integer.parseInt(numberOfPersons));
	        }
	        
			request.setAttribute("lst_img", lst_img);
			request.setAttribute("lst_roomType", lst_roomType);
			request.setAttribute("lst_roomType_search", lst_roomType_search);
			
			RequestDispatcher rd = request.getRequestDispatcher("room_page.jsp");
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
