package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Trasaction;
import Services.ITransactionServices;
import Services.Impl.TransactionServicesImpl;

@WebServlet(urlPatterns = {"/vendor/transaction"})
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITransactionServices transactionServices = new TransactionServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId= req.getParameter("userId");
		RequestDispatcher rq = req.getRequestDispatcher("/view/vendor/transaction.jsp");
		List<Trasaction> transactions = transactionServices.findByUserId(Integer.parseInt(userId));
		req.setAttribute("transactions", transactions);
		req.setAttribute("userId", userId);
		rq.forward(req, resp);
	}
}
