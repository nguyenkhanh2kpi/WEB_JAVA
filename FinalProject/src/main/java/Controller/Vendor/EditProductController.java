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
import Model.Category;
import Model.Product;
import Model.Store;
import Services.ICategoryServices;
import Services.IProductServices;
import Services.IStoreServices;
import Services.Impl.CategorySevies;
import Services.Impl.ProductServicesImpl;
import Services.Impl.StoreServicesImpl;
import Utils.Constant;


@WebServlet(urlPatterns = {"/vendor/product/edit"})
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String fileNamew;
	int id_goc;
	int id_store;
	IProductServices productServices = new ProductServicesImpl();
	ICategoryServices categoryServices = new CategorySevies();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productId");
		Product product = productServices.findById(Integer.parseInt(id));
		id_store = product.getStoreId();
		List<Category> categorys = new ArrayList<Category>();
		categorys = categoryServices.findAll();
		id_goc = product.getId();
		fileNamew = product.getImages();
		request.setAttribute("product", product);
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/vendor/editProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setId(id_goc);
		product.setImages(fileNamew);
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
				else if(item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("quantity")) {
					product.setQuantity(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("storeId")) {
					product.setStoreId(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("image") && item.toString().contains(".")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIRR + "/"+ fileName);
					item.write(file);
					product.setImages(fileName);
				}
				product.setActive(true);
			}
			productServices.Update(product);
			response.sendRedirect(request.getContextPath() + "/vendor/product?storeId="+id_store);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
