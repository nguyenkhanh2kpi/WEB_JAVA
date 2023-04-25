package Controller.Vendor;

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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.ICategoryDAO;
import DAO.Impl.CategoryDAO;
import Model.Category;
import Model.Product;
import Services.IProductServices;
import Services.Impl.ProductServicesImpl;
import Utils.Constant;


@WebServlet(urlPatterns = {"/vendor/product/add"})
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductServices productServices = new ProductServicesImpl();
	ICategoryDAO categoryDAO = new CategoryDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categorys = new ArrayList<Category>();
		categorys = categoryDAO.findAll();
		String storeId= req.getParameter("storeId");
		req.setAttribute("storeId", storeId);
		req.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/addProduct.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} 
				else if(item.getFieldName().equals("slug")) {
					product.setSlug(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("quantity")) {
					product.setQuantity(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("categoryId")) {
					product.setCategoryId(Integer.parseInt(item.getString("UTF-8")));
				}
				
				else if(item.getFieldName().equals("storeId")) {
					product.setStoreId(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("images")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIRR_Prodcuct + "/"+ fileName);
					item.write(file);
					product.setImages(fileName);
				}
				product.setActive(true);
			}
			productServices.Insert(product);
			response.sendRedirect(request.getContextPath() + "/vendor/product?storeId="+product.getStoreId());
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
