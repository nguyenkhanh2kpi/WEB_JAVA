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

import Model.Product;
import Model.Store;
import Model.User;
import Services.IProductServices;
import Services.IStoreServices;
import Services.IUserServices;
import Services.Impl.ProductServicesImpl;
import Services.Impl.StoreServicesImpl;
import Services.Impl.UserServices;
import Utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/store/list", "/admin/store/product/list" })
public class StoreAdminController extends HttpServlet {
	IUserServices userService = new UserServices();
	IStoreServices storeService = new StoreServicesImpl();
	IProductServices productService = new ProductServicesImpl();
	
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
			}
		}

	}

	private void doGet_index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("userList", userService.findAll());
		req.setAttribute("roleList", userService.findAllRole());
		if (url.contains("/admin/store/list")) {
			req.setAttribute("storeProductList", storeService.storeProductList());
			req.getRequestDispatcher("/view/admin/store_management.jsp").forward(req, resp);
		}else if (url.contains("/admin/store/product/list")) {
			String id = req.getParameter("idStore");
			String active = req.getParameter("active");
			req.setAttribute("listProductActive", productService.listProductActive(Integer.parseInt(id), Integer.parseInt(active)));
			req.setAttribute("infoStore", storeService.FindById(Integer.parseInt(id)));
			req.getRequestDispatcher("/view/admin/store_product_management.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("block")) {
			doPost_block(req, resp);
		} else if (action.equalsIgnoreCase("unblock")) {
			doPost_unblock(req, resp);
		}
	}

	private void doPost_unblock(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/store/list")) {
			int id = Integer.parseInt(req.getParameter("id"));
			storeService.unblockStore(id);
		}else if(url.contains("/admin/store/product/list")) {
			int id = Integer.parseInt(req.getParameter("id"));
			productService.unblockProduct(id);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/store/list");

	}

	private void doPost_block(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		int id = Integer.parseInt(req.getParameter("id"));
		if (url.contains("/admin/store/list")) {
			storeService.blockStore(id);
		}else if(url.contains("/admin/store/product/list")) {
			productService.blockProduct(id);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/store/list");
	}

}
