package Controller.Vendor;

import java.io.File;
import java.io.IOException;
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

import Model.Store;
import Services.IStoreServices;
import Services.Impl.StoreServicesImpl;
import Utils.Constant;

@WebServlet(urlPatterns = { "/vendor/store/add" })
public class AddStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer userID_luu=0;
	IStoreServices storeServices = new StoreServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/addStore.jsp");
		String userID = req.getParameter("userId");
		userID_luu=Integer.parseInt(userID);
		req.setAttribute("userId", userID);
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Store store = new Store();
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
					store.setName(item.getString("UTF-8"));
				} 
				else if(item.getFieldName().equals("ownId")) {
					store.setOwnerId(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("conmissionId")) {
					store.setCommissionId(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("bio")) {
					store.setBio(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("slug")) {
					store.setSlug(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("wallet")) {
					store.setE_wallet(Integer.parseInt(item.getString("UTF-8")));
				}
				else if(item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIRR + "/"+ fileName);
					item.write(file);
					store.setAvatar(fileName);
				}
				store.setActive(true);
			}
			store.setOwnerId(userID_luu);
			storeServices.Insert(store);
			response.sendRedirect(request.getContextPath() + "/vendor/store?userId="+store.getOwnerId());
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
