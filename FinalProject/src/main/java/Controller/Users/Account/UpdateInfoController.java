package Controller.Users.Account;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.User;
import Services.User.Impl.UserServicesImpl;
import Utils.Constant;
@WebServlet(urlPatterns = {"/user/updateInfo"})
public class UpdateInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("account");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/useraccount/manageAccount.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("full_name")) {
					user.setFull_name(item.getString("UTF-8"));
				}
				if (item.getFieldName().equals("id_card")) {
					user.setId_card(item.getString("UTF-8"));
				}
				if (item.getFieldName().equals("phone")) {
					user.setPhone(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR +"/"+ fileName);
					item.write(file);
					user.setAvatar(fileName);
				}
			}
			UserServicesImpl service = new UserServicesImpl();
			HttpSession session = req.getSession(false);
			User account = (User) session.getAttribute("account");
			service.updateInfor(user.getFull_name(),user.getId_card(),user.getPhone(),user.getAvatar(), account.getFull_name());
			resp.sendRedirect(req.getContextPath() + "/user/myaccount");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/user/myaccount");
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
