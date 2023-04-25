package Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IIncomeDAO;
import DAO.Impl.IncomeDAOImpl;
import Model.Income;
import Model.MonthIncome;

@WebServlet(urlPatterns = {"/vendor/report"})
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IIncomeDAO incomeDAO = new IncomeDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userId");
		List<Income> incomes= new ArrayList<Income>();
		incomes = incomeDAO.IncomeUserId(Integer.parseInt(userID));
		
		MonthIncome monthInmome = new MonthIncome();
		totalIncome(monthInmome, incomes);
	
		req.setAttribute("incomes", incomes);
		req.setAttribute("monthInmome", monthInmome);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/report.jsp");
		dispatcher.forward(req, resp);
	}
	
	public static void totalIncome(MonthIncome monthIn,List<Income> incomes) {
		for (Income income : incomes) {
			if(income.getDateComplete().getMonth()==0) {
				monthIn.january+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==1) {
				monthIn.february+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==2) {
				monthIn.march+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==3) {
				monthIn.april+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==4) {
				monthIn.may+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==5) {
				monthIn.june+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==6) {
				monthIn.july+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==7) {
				monthIn.august+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==8) {
				monthIn.september+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==9) {
				monthIn.october+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==10) {
				monthIn.november+=income.getIncome();
			}
			 if(income.getDateComplete().getMonth()==11) {
				monthIn.december+=income.getIncome();
			}
		}
	}
		
	public static void main(String[] args) {
		IIncomeDAO incomeDAO = new IncomeDAOImpl();
		
		List<Income> incomes=incomeDAO.IncomeUserId(1);
		MonthIncome monthInmome = new MonthIncome();
		totalIncome(monthInmome, incomes);
		System.out.println(monthInmome);
	
	}
}
