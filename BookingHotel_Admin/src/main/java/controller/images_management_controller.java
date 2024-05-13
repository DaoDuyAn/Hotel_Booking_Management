package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.images_bean;
import bo.images_bo;

/**
 * Servlet implementation class images_management_controller
 */
@WebServlet("/images_management_controller")
public class images_management_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public images_management_controller() {
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
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "img";

			images_bo imgbo = new images_bo();

			ArrayList<images_bean> ds = new ArrayList<images_bean>();
			String rtid = request.getParameter("rtid");

			if (request.getContentLength() <= 0) { // Chạy lần đầu

				if (rtid != null) {
					ds = imgbo.getImagesByRtId(Integer.parseInt(rtid));
				}
				request.setAttribute("roomtypeid", rtid);
				request.setAttribute("ds", ds);

				RequestDispatcher rd = request.getRequestDispatcher("images_management_page.jsp");
				rd.forward(request, response);
				return;
			}

			String img_id = null, img_link = null, rt_id = null, btnadd = null, btnupdate = null, btndel = null, btnselect = null;
			ArrayList<String> lst_img = new ArrayList<String>();

			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {

						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("")+ File.separator + "img";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}

						String fileImg = dirUrl + File.separator + nameimg;
						System.out.println("File: " + fileImg);
						
						File file = new File(fileImg);// tạo file
						try {
							
							fileItem.write(file);// lưu file
							lst_img.add("img/" + nameimg);
							// System.out.println("UPLOAD THÀNH CÔNG...!");
							// System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					String txt = fileItem.getFieldName();

					if (txt.equals("txtimgid")) {
						img_id = fileItem.getString();
					}

					if (txt.equals("txtlink")) {
						img_link = fileItem.getString();
					}

					if (txt.equals("btnadd")) {
						btnadd = fileItem.getString();
					}

					if (txt.equals("btnupdate")) {
						btnupdate = fileItem.getString();
					}

					if (txt.equals("btndel")) {
						btndel = fileItem.getString();
					}
					if (txt.equals("btnselect")) {
						btnselect = fileItem.getString();
					}

				}
			}

			if (btnadd != null) {
				for (String item : lst_img) {
					int addImg = imgbo.addImage(item, Integer.parseInt(rtid));

				}
				request.setAttribute("success", "Successful addition!");
			}

			if (btnupdate != null) {
				for (String item : lst_img) {
					int updateImg = imgbo.updateImage(Integer.parseInt(img_id), item);

				}
				request.setAttribute("success", "Successful edition!");
			}

			if (btndel != null) {
				int delImg = imgbo.deleteImage(Integer.parseInt(img_id));
				request.setAttribute("success", "Successful deletion!");
			}

			if (btnselect != null) {
				request.setAttribute("img", imgbo.getImagesById(Integer.parseInt(btnselect)));
			}

			if (rtid != null) {
				ds = imgbo.getImagesByRtId(Integer.parseInt(rtid));

			}
			request.setAttribute("roomtypeid", rtid);
			request.setAttribute("ds", ds);

			RequestDispatcher rd = request.getRequestDispatcher("images_management_page.jsp");
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
