

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
//import org.apache.tomcat.jni.User;

import CApp.CustomerApp;
import spendingPower.Company;
import spendingPower.Customer;



/**
 * Servlet implementation class ProcessName
 */
@WebServlet("/CheckName")
public class ProcessName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String result = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	public ProcessName() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nextURL = "/output.jsp";
		String message = result;
	
		
		request.setAttribute("message", message);
		
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//User user = null;
		//user.setUsername(request.getParameter("firstName")+" "+request.getParameter("lastName"));
		//session.setAttribute("user", user);
		
		result = CustomerApp.getCustomer(request.getParameter("firstName"),request.getParameter("lastName"));
		//CustomerApp.getCustomer("Adele", "Dean");
		
		if(result.equals("")){
		Customer cuss = new Customer("Mrs.", request.getParameter("firstName"), request.getParameter("lastName"), "Somewhere", "Gaithersburg", "MD", 20584, "testemail@email.com", "coprogrammer", new Company());
		session.setAttribute("customer", cuss);
		String nextURL = "/outputCustomer.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		}
		else{
		doGet(request, response);
		}
	}

}
