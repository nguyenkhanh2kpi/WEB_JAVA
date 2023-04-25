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

import Model.Category;
import Model.User;
import Services.ICategoryServices;
import Services.IUserServices;
import Services.Impl.CategorySevies;
import Services.Impl.UserServices;
import Utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/categories/list", "/admin/categories/add" })
public class ProductCatalogueController extends HttpServlet {

	IUserServices userService = new UserServices();
	ICategoryServices categoryService = new CategorySevies();

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

	private void doGet_find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		int id = Integer.parseInt(req.getParameter("id"));
		Category category = categoryService.findById(id);
		Gson gson = new Gson();
		PrintWriter writer = resp.getWriter();
		writer.print(gson.toJson(category));
		writer.flush();
		writer.close();

	}

	private void doGet_index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("roleList", userService.findAllRole());
		req.setAttribute("categoryList", categoryService.findAll());
		if (url.contains("/admin/categories/list")) {
			req.getRequestDispatcher("/view/admin/list_product_catalogue.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/view/admin/add_product_catalogue.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/categories/add")) {
			doPost_create(req, resp);
		}
		if (url.contains("/admin/categories/list")) {
			String action = req.getParameter("action");
			if (action.equals("update")) {
				doPost_update(req, resp);
			}
		}

	}

	private void doPost_create(HttpServletRequest req, HttpServletResponse resp) {
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {

				if (item.getFieldName().equals("title")) {
					category.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("slug")) {
					category.setSlug(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("avatar")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					category.setImage("category/" + fileName);
				}

			}
			categoryService.insertCategory(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories/add");
		} catch (

		FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void doPost_update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * int id = Integer.parseInt(req.getParameter("id"));
		 * 
		 * User user = userService.findById(id);
		 * user.setFull_name(req.getParameter("full_name"));
		 * user.setPhone(req.getParameter("phone"));
		 * user.setPassword(req.getParameter("password"));
		 * user.setAvatar(req.getParameter("avatar"));
		 * user.setId_role(Integer.parseInt(req.getParameter("id_role")));
		 * userService.updateUser(user); resp.sendRedirect("home");
		 */
		Category category = new Category();
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
					category.setId(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("name")) {
					category.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("slug")) {
					category.setSlug(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {// neu cofile d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file);
						category.setImage("category/" + fileName);
					} else {
						category.setImage(null);
					}
				}

			}
			categoryService.editCategory(category); 
			resp.sendRedirect(req.getContextPath() + "/admin/categories/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
