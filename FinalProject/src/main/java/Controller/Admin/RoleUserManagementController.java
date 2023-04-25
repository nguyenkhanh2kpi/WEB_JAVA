package Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import Model.User;
import Services.IUserServices;
import Services.Impl.UserServices;
import Utils.Constant;

@SuppressWarnings("serial")
@WebServlet("/admin/user_management/role")
public class RoleUserManagementController extends HttpServlet {

	IUserServices userService = new UserServices();
	int idRole = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User obj = (User) session.getAttribute("account");
		if (obj == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			User userLogged = userService.findById(obj.getId());
			req.setAttribute("userLogged", userLogged);
			String action = req.getParameter("action");
			if (action == null) {
				doGet_index(req, resp);
			} else {
				if (action.equalsIgnoreCase("find")) {
					doGet_find(req, resp);
				}
			}

		}
	}

	private void doGet_find(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.findById(id);
		Gson gson = new Gson();
		PrintWriter writer = resp.getWriter();
		writer.print(gson.toJson(user));
		writer.flush();
		writer.close();
		
	}

	private void doGet_index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		idRole = Integer.parseInt(req.getParameter("idRole"));
		req.setAttribute("userList", userService.findAllUserByRoleId(idRole));
		req.setAttribute("roleList", userService.findAllRole());
		req.getRequestDispatcher("/view/admin/user_management_by_role.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if(action.equalsIgnoreCase("create")) {
			doPost_create(req, resp);
		}
		else if(action.equalsIgnoreCase("block")) {
			doPost_block(req, resp);
		}
		else if(action.equalsIgnoreCase("unblock")) {
			doPost_unblock(req, resp);
		}
		else if(action.equals("update")) {
			doPost_update(req, resp);
		}
	}
	private void doPost_update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					user.setId(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("id_role")) {
					user.setId_role(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("full_name")) {
					 user.setFull_name(item.getString("UTF-8")); 
				} else if (item.getFieldName().equals("id_card")) {
					 user.setId_card(item.getString("UTF-8")); 
				} else if (item.getFieldName().equals("phone")) {
					 user.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("password")) {
					 user.setPassword(item.getString("UTF-8")); 
				} else if (item.getFieldName().equals("slug")) {
					 user.setSlug(item.getString("UTF-8")); 
				} else if (item.getFieldName().equals("avatar")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file);
						user.setAvatar("category/" + fileName);
					} else {
						user.setAvatar(null);
					}
				}
			}
			userService.editUser(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user_management/role?idRole=" + idRole);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void doPost_unblock(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userService.unblockUser(id);
		resp.sendRedirect(req.getContextPath() + "/admin/user_management/role?idRole=" + idRole);
		
	}
	private void doPost_block(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userService.blockUser(id);
		resp.sendRedirect(req.getContextPath() + "/admin/user_management/role?idRole=" + idRole);
	}

	private void doPost_create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id_role")) {
					user.setId_role(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("full_name")) {
					user.setFull_name(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("id_card")) {
					user.setId_card(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("phone")) {
					user.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("password")) {
					user.setPassword(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("slug")) {
					user.setSlug(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("avatar")) {

					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					user.setAvatar("category/" + fileName);
				}
			}
			userService.insertUser(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user_management/role?idRole=" + idRole);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
