package controller;

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
 * Servlet implementation class room_detail_controller
 */
@WebServlet("/room_detail_controller")
public class room_detail_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public room_detail_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8"); // client gửi data lên server bằng utf-8
			response.setCharacterEncoding("utf-8");

			images_bo imgbo = new images_bo();
			room_type_bo roomtypebo = new room_type_bo();
			
			ArrayList<room_type_bean> lst_roomType_search = roomtypebo.getAllRoomType();
			request.setAttribute("lst_roomType_search", lst_roomType_search);
			
			String id = request.getParameter("id");
			
			if (id != null) {
				ArrayList<images_bean> lst_img = imgbo.getImagesById(Integer.parseInt(id));
				room_type_bean rt = roomtypebo.getRoomTypeById(Integer.parseInt(id));
				
				request.setAttribute("lst_img", lst_img);
				request.setAttribute("rt", rt);
			}

			RequestDispatcher rd = request.getRequestDispatcher("room_detail_page.jsp");
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
